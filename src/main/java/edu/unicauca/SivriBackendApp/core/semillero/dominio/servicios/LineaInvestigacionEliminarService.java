package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.LineaInvestigacionEliminarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.LineaInvestigacionObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.LineaInvestigacionEliminarREPO;
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
