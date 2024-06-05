package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.email.dto.MetaData;
import edu.unicauca.SivriBackendApp.common.email.dto.SendRequest;
import edu.unicauca.SivriBackendApp.common.email.service.SendMessageService;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.CreateCredentialDTORequest;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.Credencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.CredentialService;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificacionDeUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioSolicitudCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.UsuarioCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.UsuarioSolicitudCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.UsuarioSolicitudEliminarREPO;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.UsuarioSolicitudObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores.UsuarioSolicitudValidador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * El servicio UsuarioSolicitudCrearService implementa la lógica para crear, editar, devolver con observaciones
 * y aprobar solicitudes de usuarios en el sistema, gestionando las operaciones a través de repositorios
 * y validaciones correspondientes.
 */
@Service
@RequiredArgsConstructor
public class UsuarioSolicitudCrearService implements UsuarioSolicitudCrearCU {

    /** Servicios */
    private final ServicioDeIdentificacionDeUsuario servicioDeIdentificacionDeUsuario;
    private final CredentialService credentialService;
    private final SendMessageService sendMessageService;

    /** Puertos de Salida */
    private final UsuarioSolicitudCrearREPO usuarioSolicitudCrearREPO;
    private final UsuarioSolicitudEliminarREPO usuarioSolicitudEliminarREPO;
    private final UsuarioCrearREPO usuarioCrearREPO;
    private final UsuarioSolicitudObtenerREPO usuarioSolicitudObtenerREPO;

    /** Validadores */
    private final UsuarioSolicitudValidador usuarioSolicitudValidador;


    /**
     * @see UsuarioSolicitudCrearCU#crearSolicitudUsuario(UsuarioSolicitud)
     */
    @Override
    public Respuesta<Boolean> crearSolicitudUsuario(UsuarioSolicitud usuario) {

        // Valída que no existan duplicados en la creación de solicitudes de usuario y que se tiene el acceso corrécta para realizar la solicitud.
        usuarioSolicitudValidador.validarLaCreacionDeUnaSolicitudDeUsuario(usuario);

        // Fijamos el usuario que está ejecutando la acción
        usuario.setCreadoPor(servicioDeIdentificacionDeUsuario.obtenerUsuario());

        // Al crear la solicitud el estado del usuario debe ser REVISION_VRI
        usuario.setEstado(EstadoSolicitudUsuario.REVISION_VRI);

        // Enviar el registro a la Base de datos
        usuarioSolicitudCrearREPO.crearSolicitudUsuario(usuario);

        return new RespuestaHandler<>(200, "ok.usuario.solicitud.creación", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento(), usuario.getCorreo()), "", true).getRespuesta();
    }

    /**
     * @see UsuarioSolicitudCrearCU#aprobarSolicitudUsuario(Long)
     */
    @Override
    public Respuesta<Boolean> aprobarSolicitudUsuario(Long solicitudUsuarioId) {

        // Válida que la aprobacion puede llevarse a cabo.
        usuarioSolicitudValidador.validarAprobacionDeUnaSolicitudDeUsuario(solicitudUsuarioId);

        // Obtener los datos del usuario a crear
        UsuarioSolicitud solicitudUsuario = usuarioSolicitudObtenerREPO.obtenerSolicitudUsuarioPorId(solicitudUsuarioId).orElseThrow();

        // Se elimina la solicitud de usuario
        usuarioSolicitudEliminarREPO.eliminarSolicitudUsuario(solicitudUsuarioId);

        // Se crea el usuario en el sistema
        Usuario nuevoUsuario = usuarioCrearREPO.crearUsuario(
                Usuario.builder()
                        .correo(solicitudUsuario.getCorreo())
                        .tipoDocumento(solicitudUsuario.getTipoDocumento())
                        .numeroDocumento(solicitudUsuario.getNumeroDocumento())
                        .sexo(solicitudUsuario.getSexo())
                        .tipoUsuario(solicitudUsuario.getTipoUsuario())
                        .nombre(solicitudUsuario.getNombre())
                        .apellido(solicitudUsuario.getApellido())
                        .telefono(solicitudUsuario.getTelefono())
                        .cvLac(solicitudUsuario.getCvLac())
                        .build()
        );

        // Si es Docente o Administrativo se crean credenciales
        if (nuevoUsuario.getTipoUsuario().equals(TipoUsuario.DOCENTE) || nuevoUsuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRATIVO)) {
            Credencial credencial = credentialService.createCredential(
                    CreateCredentialDTORequest.builder()
                    .userId(nuevoUsuario.getId())
                    .email(nuevoUsuario.getCorreo())
                    .password(nuevoUsuario.getNumeroDocumento())
                    .build()
            );

            // Enviar Correo de Bienvenida
            enviarCorreo(nuevoUsuario.getCorreo(), nuevoUsuario.getNombre() + " " + nuevoUsuario.getApellido(), credencial.getPasswordRecoveryCode());
        }

        return new RespuestaHandler<>(200, "ok.solicitud.aprobada", List.of(nuevoUsuario.getTipoDocumento().toString(), nuevoUsuario.getNumeroDocumento(), nuevoUsuario.getCorreo()), "", true).getRespuesta();
    }


    /**
     * Envía un correo de bienvenida al nuevo usuario, incluyendo información personalizada
     * como el nombre, tipo de usuario, grupo de investigación, etc.
     *
     * @param emailDestino      Correo de destino
     * @param nombreCompleto    Nombre del Usuario Creado
     * @param passwordCode      Código de seguridad para la asignación de password
     */
    private void enviarCorreo(String emailDestino, String nombreCompleto, String passwordCode) {
        List<MetaData> metaData = new ArrayList<>();
        metaData.add(MetaData.builder()
                .key("nombreCompleto")
                .value(nombreCompleto)
                .build());
        metaData.add(MetaData.builder()
                .key("passwordCode")
                .value(passwordCode)
                .build());

        sendMessageService.sendMessage(SendRequest.builder()
                .to(emailDestino)
                .subject("Te damos la bienvenida a SIVRI")
                .template(1)
                .metaData(metaData)
                .build());
    }

}