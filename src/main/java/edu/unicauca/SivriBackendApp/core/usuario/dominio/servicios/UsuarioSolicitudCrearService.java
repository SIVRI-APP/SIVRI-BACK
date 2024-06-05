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
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida.*;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudConversacion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores.UsuarioSolicitudValidador;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada.EnviarParaRevisionDTO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada.RechazarSolicitudDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
    private final UsuarioSolicitudObtenerREPO usuarioSolicitudObtenerREPO;
    private final UsuarioSolicitudCrearREPO usuarioSolicitudCrearREPO;
    private final UsuarioCrearREPO usuarioCrearREPO;
    private final UsuarioSolicitudObservacionCrearREPO usuarioSolicitudObservacionCrearREPO;
    private final UsuarioSolicitudConversacionCrearREPO usuarioSolicitudConversacionCrearREPO;
    private final UsuarioSolicitudEliminarREPO usuarioSolicitudEliminarREPO;

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
            enviarCorreoBienvenidaSivri(nuevoUsuario.getCorreo(), nuevoUsuario.getNombre() + " " + nuevoUsuario.getApellido(), credencial.getPasswordRecoveryCode());
        }

        return new RespuestaHandler<>(200, "ok.solicitud.aprobada", List.of(nuevoUsuario.getTipoDocumento().toString(), nuevoUsuario.getNumeroDocumento(), nuevoUsuario.getCorreo()), "", true).getRespuesta();
    }

    /**
     * @see UsuarioSolicitudCrearCU#rechazarSolicitudUsuario(RechazarSolicitudDTO)
     */
    @Override
    public Respuesta<Boolean> rechazarSolicitudUsuario(RechazarSolicitudDTO rechazarSolicitudDTO) {
        UsuarioSolicitud solicitud =  usuarioSolicitudObtenerREPO.obtenerSolicitudUsuarioPorId(rechazarSolicitudDTO.getUsuarioSolicitudId()).orElseThrow();

        // Si se crea una observacion por primera vez
        if (!usuarioSolicitudObtenerREPO.solicitudTieneObservaciones(rechazarSolicitudDTO.getUsuarioSolicitudId())){
            UsuarioSolicitudObservaciones nuevaObservacion = UsuarioSolicitudObservaciones.builder()
                                    .solicitudUsuario(solicitud)
                                    .funcionario(servicioDeIdentificacionDeUsuario.obtenerFuncionarioModel())
                                    .observación(rechazarSolicitudDTO.getObservacion())
                                    .fechaObservación(LocalDate.now())
                                    .resuelta(false)
                                    .build();
            // Creamos la observacion
            usuarioSolicitudObservacionCrearREPO.crearObservacion(nuevaObservacion);
        }else{
            // Si ya hay una observacion lo demás son mensajes parte de una conversacion
            Usuario usuarioAutenticado = servicioDeIdentificacionDeUsuario.obtenerUsuario();
            // Obtenemos la Observacion de la Solicitud
            UsuarioSolicitudObservaciones observacion = solicitud.getObservaciones();

            // Si la Observacion estaba resuelta, revertir a no resuelta
            if (observacion.getResuelta()){
                usuarioSolicitudObservacionCrearREPO.cambiarEstado(rechazarSolicitudDTO.getUsuarioSolicitudId());
            }

            // Creamos una nueva conversacion
            UsuarioSolicitudConversacion usuarioSolicitudConversacion = UsuarioSolicitudConversacion.builder()
                            .usuarioSolicitudObservaciones(observacion)
                            .autor(usuarioAutenticado.getNombre() + " " + usuarioAutenticado.getApellido())
                            .mensaje(rechazarSolicitudDTO.getObservacion())
                            .fechaMensaje(LocalDateTime.now())
                            .build();
            // Añadimos una conversacion
            usuarioSolicitudConversacionCrearREPO.agregarConversacion(usuarioSolicitudConversacion);
        }

        //Actualizamos el estado de la Solicitud
        usuarioSolicitudCrearREPO.cambiarEstado(rechazarSolicitudDTO.getUsuarioSolicitudId(), EstadoSolicitudUsuario.FORMULADO_OBSERVACIONES);

        // Enviamos alerta por correo electrónico
        enviarNotificacionElectronica(solicitud.getCreadoPor().getCorreo(),
                "La solicitud para la creación del usuario " + solicitud.getNombre() + " " + solicitud.getApellido()
                        + " " + solicitud.getTipoDocumento() + ": " + solicitud.getNumeroDocumento()
                        + " ha sido devuelta con observaciones con la siguiente observación: <strong>"+ rechazarSolicitudDTO.getObservacion() + ".</strong> Ingresa al apartado de Usuarios > Listar Solicitudes de Usuario en SIVRI para mas detalles."
        );

        return new RespuestaHandler<>(200, "ok.solicitud.observacion.agregada", "", true).getRespuesta();
    }

    /**
     * @see UsuarioSolicitudCrearCU#enviarParaRevision(EnviarParaRevisionDTO)
     */
    @Override
    public Respuesta<Boolean> enviarParaRevision(EnviarParaRevisionDTO enviarParaRevisionDTO) {
        Usuario usuarioAutenticado = servicioDeIdentificacionDeUsuario.obtenerUsuario();
        UsuarioSolicitud usuarioSolicitud = usuarioSolicitudObtenerREPO.obtenerSolicitudUsuarioPorId(enviarParaRevisionDTO.getUsuarioSolicitudId()).orElseThrow();

        // Si tiene observaciones la revision va con comentarios
        if (Objects.nonNull(usuarioSolicitud.getObservaciones())){

            usuarioSolicitudConversacionCrearREPO.agregarConversacion(
                    UsuarioSolicitudConversacion.builder()
                    .fechaMensaje(LocalDateTime.now())
                    .mensaje(enviarParaRevisionDTO.getObservacion())
                    .usuarioSolicitudObservaciones(usuarioSolicitud.getObservaciones())
                    .autor(usuarioAutenticado.getNombre() + " " + usuarioAutenticado.getApellido())
                    .build()
            );
        }else{
            // Si no simplemente cambiamos el estado de la solicitud
            usuarioSolicitudCrearREPO.cambiarEstado(usuarioSolicitud.getId(), EstadoSolicitudUsuario.REVISION_VRI);
        }


        return new RespuestaHandler<>(200, "ok.solicitud.observacion.revision", "", true).getRespuesta();
    }


    /**
     * Envía un correo de bienvenida al nuevo usuario, incluyendo información personalizada
     * como el nombre, tipo de usuario, grupo de investigación, etc.
     *
     * @param emailDestino      Correo de destino
     * @param nombreCompleto    Nombre del Usuario Creado
     * @param passwordCode      Código de seguridad para la asignación de password
     */
    private void enviarCorreoBienvenidaSivri(String emailDestino, String nombreCompleto, String passwordCode) {
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

    /**
     * Envía por correo sobre una notificacion sobre un proceso
     *
     * @param emailDestino      Correo de destino
     * @param mensaje           Nombre del Usuario Creado
     */
    private void enviarNotificacionElectronica(String emailDestino, String mensaje){
        List<MetaData> metaData = new ArrayList<>();
        metaData.add(MetaData.builder()
                .key("mensaje")
                .value(mensaje)
                .build());

        sendMessageService.sendMessage(SendRequest.builder()
                .to(emailDestino)
                .subject("Notificación de SIVRI")
                .template(3)
                .metaData(metaData)
                .build());
    }

}