package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificaciónDeUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores.UsuarioSolicitudValidador;
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
     * Adaptador a la base de datos
     */
    private final UsuarioSolicitudCrearREPO usuarioSolicitudCrearREPO;

    /**
     * Validador de solicutudes de Usuario
     */
    private final UsuarioSolicitudValidador usuarioSolicitudValidador;

    /**
     * Servicio de Identificacion de Usuario
     */
    private final ServicioDeIdentificaciónDeUsuario servicioDeIdentificaciónDeUsuario;


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
}