package edu.unicauca.SivriBackendApp.core.proyecto.application.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.EnfoqueDiferencialDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.EnfoqueDiferencial;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface EnfoqueDiferencialDtoMapper {

    @Named("EnfoqueDiferencialDtoFullInfoProyectoDto")
    EnfoqueDiferencialDTO fullInfoProyecto(final EnfoqueDiferencial entity);

    EnfoqueDiferencial toModel(final EnfoqueDiferencialDTO dto);
}
