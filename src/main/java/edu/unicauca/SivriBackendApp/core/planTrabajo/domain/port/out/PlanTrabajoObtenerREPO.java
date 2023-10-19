package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;

import java.util.List;
import java.util.Optional;

public interface PlanTrabajoObtenerREPO {
    Boolean existePorId(int id);
    Optional<PlanTrabajo> obtenerPorId(int id);
    List<PlanTrabajo> obtenerPlanesPorIdSemillero(int idSemillero);
    List<PlanTrabajo> obtenerListadoPlanes();
}
