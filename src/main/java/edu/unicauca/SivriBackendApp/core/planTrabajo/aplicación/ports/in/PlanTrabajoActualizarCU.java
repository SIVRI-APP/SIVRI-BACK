package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;

public interface PlanTrabajoActualizarCU {
    Respuesta<Boolean> actualizar(int idPlan, PlanTrabajo nuevosDatosPlan);

}
