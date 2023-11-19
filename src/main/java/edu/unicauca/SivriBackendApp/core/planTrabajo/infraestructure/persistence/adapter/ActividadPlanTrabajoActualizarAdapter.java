package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out.ActividadPlanTrabajoActualizarREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.mapper.ActividadPlanTrabajoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.ActividadPlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaRepository.IActividadPlanTrabajoRepository;
import org.springframework.stereotype.Component;

@Component
public class ActividadPlanTrabajoActualizarAdapter implements ActividadPlanTrabajoActualizarREPO {
    private final IActividadPlanTrabajoRepository actividadPlanTrabajoRepository;
    private final ActividadPlanTrabajoMapper actividadPlanTrabajoMapper;

    public ActividadPlanTrabajoActualizarAdapter(IActividadPlanTrabajoRepository actividadPlanTrabajoRepository, ActividadPlanTrabajoMapper actividadPlanTrabajoMapper) {
        this.actividadPlanTrabajoRepository = actividadPlanTrabajoRepository;
        this.actividadPlanTrabajoMapper = actividadPlanTrabajoMapper;
    }

    @Override
    public Boolean actualizar(ActividadPlanTrabajo nuevosDatosActividad) {
        System.out.println("datos adpter "+nuevosDatosActividad);
        ActividadPlanTrabajoEntity mapper=actividadPlanTrabajoMapper.obtenerEntity(nuevosDatosActividad);
        System.out.println("DATOS DESPUES DEL MAPEO "+mapper);
        ActividadPlanTrabajoEntity guardar = actividadPlanTrabajoRepository.save(mapper);
        System.out.println("datos guardados "+guardar);
        return true;
    }
}
