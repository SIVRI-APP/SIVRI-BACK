package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface ActividadPlanTrabajoEliminarCU {
    Respuesta<Boolean> eliminadoFisico(int id);
}
