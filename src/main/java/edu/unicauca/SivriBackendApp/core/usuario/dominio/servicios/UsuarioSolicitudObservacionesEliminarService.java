package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioSolicitudObservacionesEliminarCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioSolicitudObservacionesObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudObservaciónEliminarREPO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UsuarioSolicitudObservacionesEliminarService implements UsuarioSolicitudObservacionesEliminarCU {

    private final UsuarioSolicitudObservaciónEliminarREPO usuarioSolicitudObservaciónEliminarREPO;
    private final UsuarioSolicitudObservacionesObtenerCU usuarioSolicitudObservacionesObtenerCU;

    @Override
    public Respuesta<Boolean> eliminar(long solicitudUsuarioObservaciónId) {
        // Validar que exista
        usuarioSolicitudObservacionesObtenerCU.existePorId(solicitudUsuarioObservaciónId);

        usuarioSolicitudObservaciónEliminarREPO.eliminar(solicitudUsuarioObservaciónId);

        return new RespuestaHandler<>(200, "ok", "",true).getRespuesta();
    }
}
