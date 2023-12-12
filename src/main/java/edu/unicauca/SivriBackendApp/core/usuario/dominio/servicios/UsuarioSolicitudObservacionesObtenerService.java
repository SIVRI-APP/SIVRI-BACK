package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioSolicitudObservacionesObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudObservacionesObtenerREPO;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudObservaciónListar;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UsuarioSolicitudObservacionesObtenerService implements UsuarioSolicitudObservacionesObtenerCU {

    private final UsuarioSolicitudObservacionesObtenerREPO usuarioSolicitudObservacionesObtenerREPO;

    @Override
    public Respuesta<Page<UsuarioSolicitudObservaciónListar>> listar(int pageNo, int pageSize, long solicitudUsuarioId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<UsuarioSolicitudObservaciónListar> respuestaBd = usuarioSolicitudObservacionesObtenerREPO.listar(pageable, solicitudUsuarioId);
        return new RespuestaHandler<>(200, "ok", "",respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Integer> solicitudConObservacionesPendientes(long solicitudUsuarioId) {
        Integer respuestaBd = usuarioSolicitudObservacionesObtenerREPO.solicitudConObservacionesPendientes(solicitudUsuarioId);
        return new RespuestaHandler<>(200, "ok", "",respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> existePorId(long solicitudUsuarioId) {
        if (!usuarioSolicitudObservacionesObtenerREPO.existePorId(solicitudUsuarioId)){
            throw new ReglaDeNegocioException("bad.observación.solicitud.usuario.no.existe", List.of(Long.toString(solicitudUsuarioId)));
        }
        return new RespuestaHandler<>(200, "ok", "",true).getRespuesta();
    }
}
