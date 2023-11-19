package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out.ActividadPlanTrabajoCrearREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.mapper.ActividadPlanTrabajoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.ActividadPlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaRepository.IActividadPlanTrabajoRepository;
import org.springframework.stereotype.Component;

@Component
public class ActividadPlanTrabajoCrearAdapter implements ActividadPlanTrabajoCrearREPO {
    private final IActividadPlanTrabajoRepository actividadPlanTrabajoRepository;
    private final ActividadPlanTrabajoMapper actividadPlanTrabajoMapper;

    public ActividadPlanTrabajoCrearAdapter(IActividadPlanTrabajoRepository actividadPlanTrabajoRepository, ActividadPlanTrabajoMapper actividadPlanTrabajoMapper) {
        this.actividadPlanTrabajoRepository = actividadPlanTrabajoRepository;
        this.actividadPlanTrabajoMapper = actividadPlanTrabajoMapper;
    }

    @Override
    public Boolean crear(ActividadPlanTrabajo nuevaActividad) {
        System.out.println("nueva actividad "+nuevaActividad);
        ActividadPlanTrabajoEntity actividad= actividadPlanTrabajoRepository.save(actividadPlanTrabajoMapper.obtenerEntity(nuevaActividad));
        System.out.println("actividad entity "+actividad);
        return true;
    }
}
