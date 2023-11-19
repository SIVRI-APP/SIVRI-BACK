package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;

public interface ActividadPlanTrabajoActualizarREPO {
    Boolean actualizar(ActividadPlanTrabajo nuevosDatosActividad);
}
