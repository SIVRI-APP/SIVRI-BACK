package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EstadoPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ListarPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ObtenerActividadPlanTrabajoxanio;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface PlanTrabajoObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<Boolean> existePorIdSemilleroyAnio(Integer idSemillero,Integer anio);
    Respuesta<PlanTrabajo> obtenerPorId(int id);
    Respuesta<List<PlanTrabajo>> obtenerPlanesPorIdSemillero(int idSemillero);
    Respuesta<Page<List<ObtenerActividadPlanTrabajoxanio>>> obtenerActividadPlanTrabajoxAnio(int pageNo, int pageSize, Integer anio, Integer idSemillero, LocalDate fechaInicio, LocalDate fechaFin);
    Respuesta<Page<List<ListarPlanTrabajo>>> listarPlanTrabajoxfiltro(int pageNo, int pageSize, Integer anio, Integer idSemillero, EstadoPlanTrabajo estado);
    Respuesta<List<PlanTrabajo>> obtenerListadoPlanes();
}
