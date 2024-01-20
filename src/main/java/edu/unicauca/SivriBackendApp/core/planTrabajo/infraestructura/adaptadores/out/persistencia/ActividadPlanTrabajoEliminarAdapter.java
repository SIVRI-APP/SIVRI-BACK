package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.ActividadPlanTrabajoEliminarREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper.ActividadPlanTrabajoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository.IActividadPlanTrabajoRepository;
import org.springframework.stereotype.Component;

@Component
public class ActividadPlanTrabajoEliminarAdapter implements ActividadPlanTrabajoEliminarREPO {
    private final IActividadPlanTrabajoRepository actividadPlanTrabajoRepository;
    private final ActividadPlanTrabajoMapper actividadPlanTrabajoMapper;

    public ActividadPlanTrabajoEliminarAdapter(IActividadPlanTrabajoRepository actividadPlanTrabajoRepository, ActividadPlanTrabajoMapper actividadPlanTrabajoMapper) {
        this.actividadPlanTrabajoRepository = actividadPlanTrabajoRepository;
        this.actividadPlanTrabajoMapper = actividadPlanTrabajoMapper;
    }

    @Override
    public Boolean eliminadoFisico(int id) {
        actividadPlanTrabajoRepository.deleteById(id);
        return true;
    }
}
