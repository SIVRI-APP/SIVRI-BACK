package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.PlanTrabajoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanTrabajoMapper {
    PlanTrabajo obtenerModelo(final PlanTrabajoEntity planTrabajoEntity);

    PlanTrabajoEntity obtenerEntity(final PlanTrabajo planTrabajo);

}
