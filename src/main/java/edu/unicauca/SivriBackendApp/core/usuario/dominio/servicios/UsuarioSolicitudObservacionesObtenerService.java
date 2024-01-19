package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObservacionesObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObservacionesObtenerREPO;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudObservaciónListarProyección;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * El servicio UsuarioSolicitudObservacionesObtenerService implementa la lógica de negocio
 * para la obtención y gestión de observaciones de solicitudes de usuarios.
 */
@Service
@AllArgsConstructor
public class UsuarioSolicitudObservacionesObtenerService implements UsuarioSolicitudObservacionesObtenerCU {

    private final UsuarioSolicitudObservacionesObtenerREPO usuarioSolicitudObservacionesObtenerREPO;

    /**
     * Lista las observaciones de una solicitud de usuario paginadas.
     *
     * @param pageNo            Número de la página.
     * @param pageSize          Tamaño de la página.
     * @param solicitudUsuarioId Identificador de la solicitud de usuario.
     * @return Respuesta que contiene la lista paginada de observaciones de la solicitud de usuario.
     */
    @Override
    public Respuesta<Page<UsuarioSolicitudObservaciónListarProyección>> listar(int pageNo, int pageSize, long solicitudUsuarioId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<UsuarioSolicitudObservaciónListarProyección> respuestaBd = usuarioSolicitudObservacionesObtenerREPO.listar(pageable, solicitudUsuarioId);
        return new RespuestaHandler<>(200, "ok", "", respuestaBd).getRespuesta();
    }

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

    /**
     * Verifica si existe una observación de solicitud de usuario por su identificador.
     *
     * @param solicitudUsuarioId Identificador de la observación de solicitud de usuario.
     * @return Respuesta que indica si la observación existe o no.
     * @throws ReglaDeNegocioException Si la observación de solicitud de usuario no existe.
     */
    @Override
    public Respuesta<Boolean> existePorId(long solicitudUsuarioId) {
        if (!usuarioSolicitudObservacionesObtenerREPO.existePorId(solicitudUsuarioId)) {
            throw new ReglaDeNegocioException("bad.observación.solicitud.usuario.no.existe", List.of(Long.toString(solicitudUsuarioId)));
        }
        return new RespuestaHandler<>(200, "ok", "", true).getRespuesta();
    }
}

