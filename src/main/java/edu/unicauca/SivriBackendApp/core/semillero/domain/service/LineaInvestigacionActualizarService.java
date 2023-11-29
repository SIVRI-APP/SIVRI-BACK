package edu.unicauca.SivriBackendApp.core.semillero.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.LineaInvestigacionActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.LineaInvestigacionObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.LineaInvestigacionActualizarREPO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LineaInvestigacionActualizarService implements LineaInvestigacionActualizarCU {
    private final LineaInvestigacionActualizarREPO lineaInvestigacionActualizarREPO;
    private final LineaInvestigacionObtenerCU lineaInvestigacionObtenerCU;
    public LineaInvestigacionActualizarService(LineaInvestigacionActualizarREPO lineaInvestigacionActualizarREPO, LineaInvestigacionObtenerCU lineaInvestigacionObtenerCU) {
        this.lineaInvestigacionActualizarREPO = lineaInvestigacionActualizarREPO;
        this.lineaInvestigacionObtenerCU = lineaInvestigacionObtenerCU;
    }

    @Override
    public Respuesta<Boolean> actualizarLinea(int idLinea, LineaInvestigacion nuevaLinea) {

        LineaInvestigacion lineaActualizar=lineaInvestigacionObtenerCU.obtenerPorId(idLinea).getData();
        lineaActualizar.setLinea(nuevaLinea.getLinea());
        Boolean respuesta=lineaInvestigacionActualizarREPO.actualizarLinea(lineaActualizar);
        if (!respuesta) {
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Linea Investigacion", "Id", String.valueOf(nuevaLinea.getId())));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Linea Investigacion"), "", true).getRespuesta();
    }
}
