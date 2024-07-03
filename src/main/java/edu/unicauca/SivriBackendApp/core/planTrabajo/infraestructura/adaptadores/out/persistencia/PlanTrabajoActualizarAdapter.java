package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.PlanTrabajoActualizarREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper.PlanTrabajoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository.IPlanTrabajoRepository;
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
        System.out.println("plan de trabajo"+ nuevoPlanTrabajo);
        planTrabajoRepository.save(planTrabajoMapper.obtenerEntity(nuevoPlanTrabajo));
        return true;
    }
}
