package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;

public interface ActividadPlanTrabajoCrearCU {
    Respuesta<Boolean> crear(int idPlan, ActividadPlanTrabajo nuevaActividad);
}
