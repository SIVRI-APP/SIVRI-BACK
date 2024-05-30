package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ObtenerPlanTrabajoxanio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PlanTrabajoObtenerREPO {
    Boolean existePorId(int id);
    Integer existePorIdSemilleroyAnio(Integer idSemillero, Integer anio);
    Optional<PlanTrabajo> obtenerPorId(int id);
    List<PlanTrabajo> obtenerPlanesPorIdSemillero(int idSemillero);
    Page<List<ObtenerPlanTrabajoxanio>> obtenerPlanTrabajoxAnio(Pageable pageable, Integer anio, Integer idSemillero, LocalDate fechaInicio, LocalDate fechaFin);
    List<PlanTrabajo> obtenerListadoPlanes();
}
