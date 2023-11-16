package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;

public interface ActividadPlanTrabajoActualizarCU {
    Respuesta<Boolean> actualizar(int idActividad, ActividadPlanTrabajo nuevosDatosActividad);
}
