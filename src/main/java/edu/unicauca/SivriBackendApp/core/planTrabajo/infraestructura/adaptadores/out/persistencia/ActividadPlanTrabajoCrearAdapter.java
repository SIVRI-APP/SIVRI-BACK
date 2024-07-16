package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.ActividadPlanTrabajoCrearREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.ActividadPlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper.ActividadPlanTrabajoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository.IActividadPlanTrabajoRepository;
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
       // System.out.println("nueva actividad "+nuevaActividad);
        ActividadPlanTrabajoEntity actividad= actividadPlanTrabajoRepository.save(actividadPlanTrabajoMapper.obtenerEntity(nuevaActividad));
      //  System.out.println("actividad entity "+actividad);
        return true;
    }
}
