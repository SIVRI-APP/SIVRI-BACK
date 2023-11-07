package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;

public interface ActividadPlanTrabajoCrearREPO {
    Boolean crear(ActividadPlanTrabajo nuevaActividad);
}
