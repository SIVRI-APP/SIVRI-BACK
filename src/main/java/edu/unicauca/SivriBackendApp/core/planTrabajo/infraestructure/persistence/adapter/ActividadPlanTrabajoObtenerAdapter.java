package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out.ActividadPlanTrabajoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.mapper.ActividadPlanTrabajoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.ActividadPlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaRepository.IActividadPlanTrabajoRepository;
import org.springframework.stereotype.Component;

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

}
