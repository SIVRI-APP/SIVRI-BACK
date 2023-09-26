package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.EnfoqueDiferencial;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.EnfoqueDiferencialEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface EnfoqueDiferencialInfraMapper {

    @Named("EnfoqueDiferencialFullInfoProyecto")
    EnfoqueDiferencial fullInfoProyecto(final EnfoqueDiferencialEntity entity);

    EnfoqueDiferencialEntity obtenerEntity(final EnfoqueDiferencial model);

}
