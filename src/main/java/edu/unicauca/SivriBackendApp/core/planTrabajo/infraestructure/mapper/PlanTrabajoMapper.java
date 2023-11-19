package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.PlanTrabajoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanTrabajoMapper {
    PlanTrabajo obtenerModelo(final PlanTrabajoEntity planTrabajoEntity);

    PlanTrabajoEntity obtenerEntity(final PlanTrabajo planTrabajo);

}
