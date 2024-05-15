package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificaciónDeUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObservacionesCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObservacionesObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudEliminarREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores.UsuarioSolicitudValidador;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada.RechazarSolicitudDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * El servicio UsuarioSolicitudCrearService implementa la lógica para crear, editar, devolver con observaciones
 * y aprobar solicitudes de usuarios en el sistema, gestionando las operaciones a través de repositorios
 * y validaciones correspondientes.
 */
@Service
@RequiredArgsConstructor
public class UsuarioSolicitudCrearService implements UsuarioSolicitudCrearCU {
    /**
     * CU
     */
    private final UsuarioSolicitudObtenerCU usuarioSolicitudObtenerCU;
    private final UsuarioSolicitudObservacionesObtenerCU usuarioSolicitudObservacionesObtenerCU;
    private final UsuarioSolicitudObservacionesCrearCU usuarioSolicitudObservacionesCrearCU;

    /**
     * Servicios
     */
    private final ServicioDeIdentificaciónDeUsuario servicioDeIdentificaciónDeUsuario;
    private final UsuarioCrearService usuarioCrearService;

    /**
     * Adaptadores a la base de datos
     */
    private final UsuarioSolicitudCrearREPO usuarioSolicitudCrearREPO;
    private final UsuarioSolicitudEliminarREPO usuarioSolicitudEliminarREPO;

    /**
     * Validadores
     */
    private final UsuarioSolicitudValidador usuarioSolicitudValidador;


    /**
     * Crea una solicitud de usuario en el sistema.
     *
     * @param usuario Información del usuario a solicitar.
     * @return Respuesta que indica el éxito de la operación.
     * @throws ReglaDeNegocioException Si se viola alguna regla de negocio.
     */
    @Override
    public Respuesta<Boolean> crearSolicitudUsuario(UsuarioSolicitud usuario) {

        // Valida que no existan duplicados en la creación de solicitudes de usuario y que se tiene el acceso correcta para realizar la solicitud.
        usuarioSolicitudValidador.validarLaCreacionDeUnaSolicitudDeUsuario(usuario);

        // Fijamos el usuario que esta ejecutando la acción
        usuario.setCreadoPor(servicioDeIdentificaciónDeUsuario.obtenerUsuario());

        // Al crear la solicitud el estado del usuario debe ser REVISION_VRI
        usuario.setEstado(EstadoSolicitudUsuario.REVISION_VRI);

        // Enviar el registro a la Base de datos
        usuarioSolicitudCrearREPO.crearUsuarioSolicitud(usuario);

        return new RespuestaHandler<>(200, "ok.usuario.solicitud.creación", List.of(usuario.getTipoDocumento().toString(), usuario.getNumeroDocumento(), usuario.getCorreo()), "", true).getRespuesta();
    }

    /**
     * Aprueba una solicitud de usuario en el sistema.
     *
     * @param solicitudId Identificador de la solicitud de usuario.
     * @return Respuesta que indica el éxito de la operación.
     * @throws ReglaDeNegocioException Sí existen observaciones pendientes para la solicitud.
     */
    @Override
    public Respuesta<Boolean> aprobarSolicitudUsuario(long solicitudId) {
        UsuarioSolicitud solicitudUsuario = usuarioSolicitudObtenerCU.obtenerSolicitudUsuario(solicitudId).getData();

        if (usuarioSolicitudObservacionesObtenerCU.solicitudConObservacionesPendientes(solicitudId).getData() > 0) {
            throw new ReglaDeNegocioException("bad.no.se.puede.aprobar.solicitud.observaciones.pendientes");
        }

        // Crear usuario
        usuarioCrearService.crearUsuario(Usuario
                .builder()
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

        // TODO: Miguel crear el rol en el grupo

        // Eliminar solicitud
        usuarioSolicitudEliminarREPO.eliminar(solicitudId);

        return new RespuestaHandler<>(200, "ok.solicitud.aprobada", List.of(solicitudUsuario.getTipoDocumento().toString(), solicitudUsuario.getNumeroDocumento(), solicitudUsuario.getCorreo()), "", true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> rechazarSolicitudUsuario(RechazarSolicitudDTO rechazarSolicitud) {
        usuarioSolicitudObservacionesCrearCU.crearObservacionSolicitudUsuario(rechazarSolicitud);
        UsuarioSolicitud solicitudUsuario = usuarioSolicitudObtenerCU.obtenerSolicitudUsuario(rechazarSolicitud.getUsuarioSolicitudId()).getData();
        solicitudUsuario.setEstado(EstadoSolicitudUsuario.FORMULADO_OBSERVACIONES);

        usuarioSolicitudCrearREPO.actualizarUsuarioSolicitud(solicitudUsuario);
        return new RespuestaHandler<>(200, "ok.solicitud.rechazada", "", true).getRespuesta();
    }
}