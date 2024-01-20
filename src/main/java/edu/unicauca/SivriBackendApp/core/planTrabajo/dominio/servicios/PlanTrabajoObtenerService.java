package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.PlanTrabajoObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.PlanTrabajoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class PlanTrabajoObtenerService implements PlanTrabajoObtenerCU {
    private final PlanTrabajoObtenerREPO planTrabajoObtenerREPO;

    public PlanTrabajoObtenerService(PlanTrabajoObtenerREPO planTrabajoObtenerREPO) {
        this.planTrabajoObtenerREPO = planTrabajoObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=planTrabajoObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Plan Trabajo", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<PlanTrabajo> obtenerPorId(int id) {
        Optional<PlanTrabajo> respuestaBd= planTrabajoObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Plan Trabajo", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<PlanTrabajo>> obtenerPlanesPorIdSemillero(int idSemillero) {
        List<PlanTrabajo> respuestaBd= planTrabajoObtenerREPO.obtenerPlanesPorIdSemillero(idSemillero);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<List<PlanTrabajo>> obtenerListadoPlanes() {
        List<PlanTrabajo> respuestaBd= planTrabajoObtenerREPO.obtenerListadoPlanes();
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }
}
