package edu.unicauca.SivriBackendApp.core.semillero.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.LineaInvestigacionEliminarCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.LineaInvestigacionObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.LineaInvestigacionEliminarREPO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LineaInvestigacionEliminarService implements LineaInvestigacionEliminarCU {
    private final LineaInvestigacionEliminarREPO lineaInvestigacionEliminarREPO;
    private final LineaInvestigacionObtenerCU lineaInvestigacionObtenerCU;

    public LineaInvestigacionEliminarService(LineaInvestigacionEliminarREPO lineaInvestigacionEliminarREPO, LineaInvestigacionObtenerCU lineaInvestigacionObtenerCU) {
        this.lineaInvestigacionEliminarREPO = lineaInvestigacionEliminarREPO;
        this.lineaInvestigacionObtenerCU = lineaInvestigacionObtenerCU;
    }

    @Override
    public Respuesta<Boolean> eliminadoFisico(int id) {
        lineaInvestigacionObtenerCU.existePorId(id).getData();

        Boolean respuesta=lineaInvestigacionEliminarREPO.eliminadoFisicoLinea(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.eliminacion.objeto", List.of("Linea Investigacion", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "success.eliminacion.objeto", List.of("Linea Investigacion"), "Eliminación Fisico", true).getRespuesta();
    }
}
