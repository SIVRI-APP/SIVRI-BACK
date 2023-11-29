package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.ActividadPlanTrabajoCrearCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.CompromisoSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.PlanTrabajoObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out.ActividadPlanTrabajoCrearREPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActividadPlanTrabajoCrearService implements ActividadPlanTrabajoCrearCU {
    private final ActividadPlanTrabajoCrearREPO actividadPlanTrabajoCrearREPO;
    private final PlanTrabajoObtenerCU planTrabajoObtenerCU;
    private final CompromisoSemilleroObtenerCU compromisoSemilleroObtenerCU;
    public ActividadPlanTrabajoCrearService(ActividadPlanTrabajoCrearREPO actividadPlanTrabajoCrearREPO, PlanTrabajoObtenerCU planTrabajoObtenerCU, CompromisoSemilleroObtenerCU compromisoSemilleroObtenerCU) {
        this.actividadPlanTrabajoCrearREPO = actividadPlanTrabajoCrearREPO;
        this.planTrabajoObtenerCU = planTrabajoObtenerCU;
        this.compromisoSemilleroObtenerCU = compromisoSemilleroObtenerCU;
    }

    @Override
    public Respuesta<Boolean> crear(int idPlan, ActividadPlanTrabajo nuevaActividad) {
        System.out.println("id plan"+idPlan+" DATOS nueva actividad "+nuevaActividad);
        planTrabajoObtenerCU.existePorId(idPlan);
        compromisoSemilleroObtenerCU.existePorId(nuevaActividad.getCompromiso().getId());
        PlanTrabajo plan=planTrabajoObtenerCU.obtenerPorId(idPlan).getData();
        nuevaActividad.setPlanTrabajo(plan);
        System.out.println(" NUEVA ACTIVIDAD "+nuevaActividad);
        System.out.println("compromiso id "+nuevaActividad.getCompromiso().getId());
        Boolean respuesta= actividadPlanTrabajoCrearREPO.crear(nuevaActividad);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Actividad Plan Trabajo", "Id", String.valueOf(nuevaActividad.getId())));
        }
        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Actividad Plan Trabajo"), "", true).getRespuesta();
    }
}
