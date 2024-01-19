package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObservacionesEliminarCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObservacionesObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObservaciónEliminarREPO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * El servicio UsuarioSolicitudObservacionesEliminarService implementa la lógica de negocio
 * para la eliminación de observaciones de solicitudes de usuarios.
 */
@Service
@AllArgsConstructor
public class UsuarioSolicitudObservacionesEliminarService implements UsuarioSolicitudObservacionesEliminarCU {

    private final UsuarioSolicitudObservaciónEliminarREPO usuarioSolicitudObservaciónEliminarREPO;
    private final UsuarioSolicitudObservacionesObtenerCU usuarioSolicitudObservacionesObtenerCU;

    /**
     * Elimina una observación de solicitud de usuario.
     *
     * @param solicitudUsuarioObservaciónId Identificador de la observación de solicitud de usuario.
     * @return Respuesta que indica el éxito de la operación.
     */
    @Override
    public Respuesta<Boolean> eliminar(long solicitudUsuarioObservaciónId) {
        // Validar que la observación exista
        usuarioSolicitudObservacionesObtenerCU.existePorId(solicitudUsuarioObservaciónId);

        // Eliminar la observación de solicitud de usuario
        usuarioSolicitudObservaciónEliminarREPO.eliminar(solicitudUsuarioObservaciónId);

        return new RespuestaHandler<>(200, "ok", "", true).getRespuesta();
    }
}
