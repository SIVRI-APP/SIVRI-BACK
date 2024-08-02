package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EstadoPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ListarPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ObtenerActividadPlanTrabajoxanio;
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
    Page<List<ObtenerActividadPlanTrabajoxanio>> obtenerActividadPlanTrabajoxAnio(Pageable pageable, Integer anio, Integer idSemillero, LocalDate fechaInicio, LocalDate fechaFin);
    Page<List<ListarPlanTrabajo>> listarPlanTrabajoxfiltro(Pageable pageable, Integer anio, Integer idSemillero, EstadoPlanTrabajo estado);

    List<PlanTrabajo> obtenerListadoPlanes();
}
