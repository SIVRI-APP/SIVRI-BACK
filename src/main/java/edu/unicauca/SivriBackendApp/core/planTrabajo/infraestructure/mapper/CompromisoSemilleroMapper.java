package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.CompromisoSemillero;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.CompromisoSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.PlanTrabajoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompromisoSemilleroMapper {
    CompromisoSemillero obtenerModelo(final CompromisoSemilleroEntity planTrabajoEntity);

    CompromisoSemilleroEntity obtenerEntity(final CompromisoSemillero planTrabajo);
}
