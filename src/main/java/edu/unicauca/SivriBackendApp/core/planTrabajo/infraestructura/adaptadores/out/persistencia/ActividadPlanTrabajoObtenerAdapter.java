package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.ActividadPlanTrabajoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ListarActividadesConFiltro;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.ActividadPlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper.ActividadPlanTrabajoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository.IActividadPlanTrabajoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ActividadPlanTrabajoObtenerAdapter implements ActividadPlanTrabajoObtenerREPO {
    private final IActividadPlanTrabajoRepository actividadPlanTrabajoRepository;
    private final ActividadPlanTrabajoMapper actividadPlanTrabajoMapper;

    public ActividadPlanTrabajoObtenerAdapter(IActividadPlanTrabajoRepository actividadPlanTrabajoRepository, ActividadPlanTrabajoMapper actividadPlanTrabajoMapper) {
        this.actividadPlanTrabajoRepository = actividadPlanTrabajoRepository;
        this.actividadPlanTrabajoMapper = actividadPlanTrabajoMapper;
    }

    @Override
    public Boolean existePorId(int id) {
        return actividadPlanTrabajoRepository.existsById(id);
    }

    @Override
    public Optional<ActividadPlanTrabajo> obtenerPorId(int id) {
        Optional<ActividadPlanTrabajoEntity> respuestaJpa=actividadPlanTrabajoRepository.findById(id);

        return respuestaJpa.map(actividadPlanTrabajoMapper::obtenerModelo);
    }

    @Override
    public List<ActividadPlanTrabajo> obtenerActividadesPorIdPlanTrabajo(int idPlan) {
        return actividadPlanTrabajoRepository.findByPlanTrabajoId(idPlan).stream().map(actividadPlanTrabajoMapper::obtenerModelo).collect(Collectors.toList());
    }

    @Override
    public List<ActividadPlanTrabajo> obtenerListadoActividadesPlan() {
        return actividadPlanTrabajoRepository.findAll().stream().map(actividadPlanTrabajoMapper::obtenerModelo).collect(Collectors.toList());
    }

    @Override
    public Page<List<ListarActividadesConFiltro>> listarActividadesConFiltro(Pageable pageable, LocalDate fechaInicio, LocalDate fechaFin) {

        return actividadPlanTrabajoRepository.listarActividadesConFiltro(fechaInicio,fechaFin,pageable);
    }

}
