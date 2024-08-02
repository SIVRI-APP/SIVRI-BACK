package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.ActividadPlanTrabajoActualizarREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.ActividadPlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper.ActividadPlanTrabajoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository.IActividadPlanTrabajoRepository;
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
        ActividadPlanTrabajoEntity mapper=actividadPlanTrabajoMapper.obtenerEntity(nuevosDatosActividad);
        ActividadPlanTrabajoEntity guardar = actividadPlanTrabajoRepository.save(mapper);
        return true;
    }
}
