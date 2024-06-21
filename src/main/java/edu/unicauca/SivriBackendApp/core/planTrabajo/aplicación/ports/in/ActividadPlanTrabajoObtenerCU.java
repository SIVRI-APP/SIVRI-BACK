package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ListarActividadesConFiltro;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface ActividadPlanTrabajoObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<ActividadPlanTrabajo> obtenerPorId(int id);
    Respuesta<List<ActividadPlanTrabajo>> obtenerActividadesPorIdPlanTrabajo(int idPlan);
    Respuesta<List<ActividadPlanTrabajo>> obtenerListadoActividadesPlan();
    Respuesta<Page<List<ListarActividadesConFiltro>>> ListarActividadesConFiltro(int pageNo, int pageSize, LocalDate fechaInicio,LocalDate fechaFin);
}
