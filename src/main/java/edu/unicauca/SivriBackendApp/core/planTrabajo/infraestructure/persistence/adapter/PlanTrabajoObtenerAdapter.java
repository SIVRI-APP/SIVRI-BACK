package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out.PlanTrabajoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.mapper.PlanTrabajoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.PlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaRepository.IPlanTrabajoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlanTrabajoObtenerAdapter implements PlanTrabajoObtenerREPO {
    private final IPlanTrabajoRepository planTrabajoRepository;
    private final PlanTrabajoMapper planTrabajoMapper;

    public PlanTrabajoObtenerAdapter(IPlanTrabajoRepository planTrabajoRepository, PlanTrabajoMapper planTrabajoMapper) {
        this.planTrabajoRepository = planTrabajoRepository;
        this.planTrabajoMapper = planTrabajoMapper;
    }

    @Override
    public Boolean existePorId(int id) {
        return planTrabajoRepository.existsById(id);
    }
    @Override
    public Optional<PlanTrabajo> obtenerPorId(int  id) {
        Optional<PlanTrabajoEntity> respuestaJpa=planTrabajoRepository.findById(id);
        return respuestaJpa.map(planTrabajoMapper::obtenerModelo);
    }

    @Override
    public List<PlanTrabajo> obtenerListadoPlanes() {
        return planTrabajoRepository.findAll().stream().map(planTrabajoMapper::obtenerModelo).collect(Collectors.toList());
    }
}
