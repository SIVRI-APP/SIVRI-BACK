package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface ActividadPlanTrabajoEliminarCU {
    Respuesta<Boolean> eliminadoFisico(int id);
}
