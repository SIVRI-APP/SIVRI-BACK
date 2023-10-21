package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;

import java.util.List;
import java.util.Optional;

public interface ActividadPlanTrabajoObtenerREPO {
    Boolean existePorId(int id);
    Optional<ActividadPlanTrabajo> obtenerPorId(int id);
    List<ActividadPlanTrabajo> obtenerActividadesPorIdPlanTrabajo(int idPlan);
    List<ActividadPlanTrabajo> obtenerListadoActividadesPlan();

}
