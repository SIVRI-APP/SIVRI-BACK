package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.EnfoqueDiferencialProyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.EnfoqueDiferencialProyectoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = EnfoqueDiferencialInfraMapper.class)
public interface EnfoqueDiferencialProyectoInfraMapper {

    @Named("EnfoqueDiferencialProyectoFullInfoProyecto")
    @Mapping(source = "enfoqueDiferencial", target = "enfoqueDiferencial", qualifiedByName = "EnfoqueDiferencialFullInfoProyecto")
    @Mapping(target = "proyecto", ignore = true)
    EnfoqueDiferencialProyecto fullInfoProyecto(final EnfoqueDiferencialProyectoEntity entity);

    EnfoqueDiferencialProyectoEntity obtenerEntity(final EnfoqueDiferencialProyecto model);

}
