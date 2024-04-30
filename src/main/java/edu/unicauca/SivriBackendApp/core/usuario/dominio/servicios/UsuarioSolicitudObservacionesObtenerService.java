package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObservacionesObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObservacionesObtenerREPO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * El servicio UsuarioSolicitudObservacionesObtenerService implementa la lógica de negocio
 * para la obtención y gestión de observaciones de solicitudes de usuarios.
 */
@Service
@AllArgsConstructor
public class UsuarioSolicitudObservacionesObtenerService implements UsuarioSolicitudObservacionesObtenerCU {

    private final UsuarioSolicitudObservacionesObtenerREPO usuarioSolicitudObservacionesObtenerREPO;

    /**
     * Obtiene el número de observaciones pendientes para una solicitud de usuario.
     *
     * @param solicitudUsuarioId Identificador de la solicitud de usuario.
     * @return Respuesta que contiene el número de observaciones pendientes.
     */
    @Override
    public Respuesta<Integer> solicitudConObservacionesPendientes(long solicitudUsuarioId) {
        Integer respuestaBd = usuarioSolicitudObservacionesObtenerREPO.solicitudConObservacionesPendientes(solicitudUsuarioId);
        return new RespuestaHandler<>(200, "ok", "", respuestaBd).getRespuesta();
    }


}

