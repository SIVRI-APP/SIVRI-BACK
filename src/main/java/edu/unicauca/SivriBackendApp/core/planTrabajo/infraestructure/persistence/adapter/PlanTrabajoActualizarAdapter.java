package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out.PlanTrabajoActualizarREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.mapper.PlanTrabajoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaRepository.IPlanTrabajoRepository;
import org.springframework.stereotype.Component;

@Component
public class PlanTrabajoActualizarAdapter implements PlanTrabajoActualizarREPO {
    private final IPlanTrabajoRepository planTrabajoRepository;
    private final PlanTrabajoMapper planTrabajoMapper;

    public PlanTrabajoActualizarAdapter(IPlanTrabajoRepository planTrabajoRepository, PlanTrabajoMapper planTrabajoMapper) {
        this.planTrabajoRepository = planTrabajoRepository;
        this.planTrabajoMapper = planTrabajoMapper;
    }

    @Override
    public Boolean actualizar(PlanTrabajo nuevoPlanTrabajo) {
        planTrabajoRepository.save(planTrabajoMapper.obtenerEntity(nuevoPlanTrabajo));
        return true;
    }
}
