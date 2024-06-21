package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ObtenerPlanTrabajoxanio;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface PlanTrabajoObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<Boolean> existePorIdSemilleroyAnio(Integer idSemillero,Integer anio);
    Respuesta<PlanTrabajo> obtenerPorId(int id);
    Respuesta<List<PlanTrabajo>> obtenerPlanesPorIdSemillero(int idSemillero);

    //obtener un plan de trabajo por el año con sus respectivas actividades
    Respuesta<Page<List<ObtenerPlanTrabajoxanio>>> obtenerPlanTrabajoxAnio(int pageNo, int pageSize, Integer anio, Integer idSemillero, LocalDate fechaInicio, LocalDate fechaFin);
    Respuesta<List<PlanTrabajo>> obtenerListadoPlanes();
}
