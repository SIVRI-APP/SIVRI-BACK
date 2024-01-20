package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;

public interface ActividadPlanTrabajoCrearCU {
    Respuesta<Boolean> crear(int idPlan, ActividadPlanTrabajo nuevaActividad);
}
