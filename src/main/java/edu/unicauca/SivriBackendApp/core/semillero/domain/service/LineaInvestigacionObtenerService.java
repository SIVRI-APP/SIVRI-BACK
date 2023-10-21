package edu.unicauca.SivriBackendApp.core.semillero.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.LineaInvestigacionObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.LineaInvestigacionObtenerREPO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LineaInvestigacionObtenerService implements LineaInvestigacionObtenerCU {
    private final LineaInvestigacionObtenerREPO lineaInvestigacionObtenerREPO;

    public LineaInvestigacionObtenerService(LineaInvestigacionObtenerREPO lineaInvestigacionObtenerREPO) {
        this.lineaInvestigacionObtenerREPO = lineaInvestigacionObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=lineaInvestigacionObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Linea Investigacion", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<LineaInvestigacion> obtenerPorId(int id) {
        Optional<LineaInvestigacion> respuestaBd= lineaInvestigacionObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Linea Investigacion", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<LineaInvestigacion>> obtenerLineasInvestigacionPorSemilleroId(int idSemillero) {
        List<LineaInvestigacion> respuestaBd= lineaInvestigacionObtenerREPO.obtenerLineasInvestigacionPorSemilleroId(idSemillero);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<List<LineaInvestigacion>> obtenerListadoLineasInvestigacion() {
        List<LineaInvestigacion> respuestaBd= lineaInvestigacionObtenerREPO.obtenerListadoLineasInvestigacion();
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

}
