package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;

import java.util.List;
import java.util.Optional;

public interface PlanTrabajoObtenerREPO {
    Boolean existePorId(int id);
    Optional<PlanTrabajo> obtenerPorId(int id);
    List<PlanTrabajo> obtenerPlanesPorIdSemillero(int idSemillero);
    List<PlanTrabajo> obtenerListadoPlanes();
}
