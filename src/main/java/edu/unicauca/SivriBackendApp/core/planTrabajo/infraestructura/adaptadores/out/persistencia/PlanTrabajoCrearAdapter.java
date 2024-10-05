package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.PlanTrabajoCrearREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.PlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper.PlanTrabajoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository.IPlanTrabajoRepository;
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
        System.out.println("adapter nuevo plan "+nuevoPlan);
        PlanTrabajoEntity plan= planTrabajoRepository.save(planTrabajoMapper.obtenerEntity(nuevoPlan));
        System.out.println("adapter entity plan "+plan);
        return true;
    }
}
