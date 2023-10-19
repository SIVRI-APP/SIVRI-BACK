package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;

public interface PlanTrabajoActualizarREPO {
    Boolean actualizar (PlanTrabajo nuevoPlanTrabajo);
}
