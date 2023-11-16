package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;

public interface PlanTrabajoActualizarCU {
    Respuesta<Boolean> actualizar(int idPlan,PlanTrabajo nuevosDatosPlan);

}
