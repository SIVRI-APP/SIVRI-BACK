package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out.PlanTrabajoCrearREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.mapper.PlanTrabajoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.PlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaRepository.IPlanTrabajoRepository;
import org.springframework.stereotype.Component;

@Component
public class PlanTrabajoCrearAdapter implements PlanTrabajoCrearREPO {
    private final IPlanTrabajoRepository planTrabajoRepository;
    private final PlanTrabajoMapper planTrabajoMapper;

    public PlanTrabajoCrearAdapter(IPlanTrabajoRepository planTrabajoRepository, PlanTrabajoMapper planTrabajoMapper) {
        this.planTrabajoRepository = planTrabajoRepository;
        this.planTrabajoMapper = planTrabajoMapper;
    }

    @Override
    public Boolean crear(PlanTrabajo nuevoPlan) {
        //System.out.println("DATOS QUE llegan al adapter "+nuevoPlan);
        PlanTrabajoEntity plan= planTrabajoRepository.save(planTrabajoMapper.obtenerEntity(nuevoPlan));
        //System.out.println("PLAN ENTITY "+plan);
        return true;
    }
}
