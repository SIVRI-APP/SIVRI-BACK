package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;

import java.util.List;

public interface PlanTrabajoObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<PlanTrabajo> obtenerPorId(int id);
    Respuesta<List<PlanTrabajo>> obtenerPlanesPorIdSemillero(int idSemillero);
    Respuesta<List<PlanTrabajo>> obtenerListadoPlanes();
}
