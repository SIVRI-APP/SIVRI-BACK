package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.ActividadPlanTrabajoCrearCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.CompromisoSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.PlanTrabajoObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.ActividadPlanTrabajoCrearREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
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
        //System.out.println("service: idplan "+idPlan+" DATOS nueva actividad "+nuevaActividad);
        planTrabajoObtenerCU.existePorId(idPlan);
        compromisoSemilleroObtenerCU.existePorId(nuevaActividad.getCompromiso().getId());
        PlanTrabajo plan=planTrabajoObtenerCU.obtenerPorId(idPlan).getData();
        nuevaActividad.setPlanTrabajo(plan);
        //System.out.println(" NUEVA ACTIVIDAD "+nuevaActividad);
        Boolean respuesta= actividadPlanTrabajoCrearREPO.crear(nuevaActividad);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Actividad Plan Trabajo", "Id", String.valueOf(nuevaActividad.getId())));
        }
        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Actividad Plan Trabajo"), "", true).getRespuesta();
    }
}
