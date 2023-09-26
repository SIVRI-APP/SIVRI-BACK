package edu.unicauca.SivriBackendApp.core.proyecto.application.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.RolProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.RolProyecto;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RolProyectoDtoMapper {

    @Named("RolProyectoDtoFullInfoProyecto")
    RolProyectoDTO fullInfoProyecto(final RolProyecto entity);

    RolProyecto toModel (final RolProyectoDTO dto);
}
