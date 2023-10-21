package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.ActividadPlanTrabajoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActividadPlanTrabajoMapper {
    ActividadPlanTrabajo obtenerModelo(final ActividadPlanTrabajoEntity actividadPlanTrabajoEntity);

    ActividadPlanTrabajoEntity obtenerEntity(final ActividadPlanTrabajo actividadPlanTrabajo);

}
