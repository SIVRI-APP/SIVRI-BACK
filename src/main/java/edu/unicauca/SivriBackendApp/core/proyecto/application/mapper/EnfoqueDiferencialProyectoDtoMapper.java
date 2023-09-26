package edu.unicauca.SivriBackendApp.core.proyecto.application.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.EnfoqueDiferencialProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.EnfoqueDiferencialProyecto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = EnfoqueDiferencialDtoMapper.class)
public interface EnfoqueDiferencialProyectoDtoMapper {

    @Named("EnfoqueDiferencialProyectoDtoFullInfoProyecto")
    @Mapping(source = "enfoqueDiferencial", target = "enfoqueDiferencial", qualifiedByName = "EnfoqueDiferencialDtoFullInfoProyectoDto")
    EnfoqueDiferencialProyectoDTO fullInfoProyecto(final EnfoqueDiferencialProyecto entity);

    EnfoqueDiferencialProyecto toModel(final EnfoqueDiferencialProyectoDTO model);
}
