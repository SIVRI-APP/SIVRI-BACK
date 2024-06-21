package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.ObservacionSemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.ObservacionSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.ObservacionSemilleroActualizarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObservacionSemilleroActualizarService implements ObservacionSemilleroActualizarCU {

    private final ObservacionSemilleroActualizarREPO observacionSemilleroActualizarREPO;
    private final ObservacionSemilleroObtenerCU observacionSemilleroObtenerCU;
    public ObservacionSemilleroActualizarService(ObservacionSemilleroActualizarREPO observacionSemilleroActualizarREPO, ObservacionSemilleroObtenerCU observacionSemilleroObtenerCU) {
        this.observacionSemilleroActualizarREPO = observacionSemilleroActualizarREPO;
        this.observacionSemilleroObtenerCU = observacionSemilleroObtenerCU;
    }

    @Override
    public Respuesta<Boolean> actualizarObservacionSemillero(int idObservacion, ObservacionSemillero nuevaObservacion) {
        ObservacionSemillero observacionActualizar=observacionSemilleroObtenerCU.obtenerPorId(idObservacion).getData();
        observacionActualizar.setObservacion(nuevaObservacion.getObservacion());
        Boolean respuesta= observacionSemilleroActualizarREPO.actualizarObservacionSemillero(observacionActualizar);
        if (!respuesta) {
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Observacion Semillero", "Id", String.valueOf(nuevaObservacion.getId())));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Observacion Semillero"), "", true).getRespuesta();
    }
}
