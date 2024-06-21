package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.ActividadPlanTrabajoEliminarCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.ActividadPlanTrabajoObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.ActividadPlanTrabajoEliminarREPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActividadPlanTrabajoEliminarService implements ActividadPlanTrabajoEliminarCU {
    private final ActividadPlanTrabajoEliminarREPO actividadPlanTrabajoEliminarREPO;
    private final ActividadPlanTrabajoObtenerCU actividadPlanTrabajoObtenerCU;

    public ActividadPlanTrabajoEliminarService(ActividadPlanTrabajoEliminarREPO actividadPlanTrabajoEliminarREPO, ActividadPlanTrabajoObtenerCU actividadPlanTrabajoObtenerCU) {
        this.actividadPlanTrabajoEliminarREPO = actividadPlanTrabajoEliminarREPO;
        this.actividadPlanTrabajoObtenerCU = actividadPlanTrabajoObtenerCU;
    }

    @Override
    public Respuesta<Boolean> eliminadoFisico(int id) {
        actividadPlanTrabajoObtenerCU.existePorId(id);
        Boolean respuesta=actividadPlanTrabajoEliminarREPO.eliminadoFisico(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.eliminacion.objeto", List.of("Actividad Plan Trabajo", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "success.eliminacion.objeto", List.of("Actividad Plan Trabajo"), "Eliminación Fisico", true).getRespuesta();
    }
}
