package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;

public interface PlanTrabajoCrearREPO {
    Boolean crear(PlanTrabajo nuevoPlan);
}
