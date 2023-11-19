package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;

public interface PlanTrabajoCrearCU {
    Respuesta<Boolean> crear(int idSemillero,PlanTrabajo nuevoPlan);
}
