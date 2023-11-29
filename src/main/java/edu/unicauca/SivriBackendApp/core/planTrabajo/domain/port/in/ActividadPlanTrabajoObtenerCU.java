package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;

import java.util.List;

public interface ActividadPlanTrabajoObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<ActividadPlanTrabajo> obtenerPorId(int id);
    Respuesta<List<ActividadPlanTrabajo>> obtenerActividadesPorIdPlanTrabajo(int idPlan);
    Respuesta<List<ActividadPlanTrabajo>> obtenerListadoActividadesPlan();
}
