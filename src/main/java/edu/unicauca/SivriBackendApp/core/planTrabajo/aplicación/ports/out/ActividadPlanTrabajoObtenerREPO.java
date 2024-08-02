package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ListarActividadesConFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ActividadPlanTrabajoObtenerREPO {
    Boolean existePorId(int id);
    Optional<ActividadPlanTrabajo> obtenerPorId(int id);
    List<ActividadPlanTrabajo> obtenerActividadesPorIdPlanTrabajo(int idPlan);
    List<ActividadPlanTrabajo> obtenerListadoActividadesPlan();
    Page<List<ListarActividadesConFiltro>> listarActividadesConFiltro(Pageable pageable,Integer idPlan, LocalDate fechaInicio, LocalDate fechaFin);

}
