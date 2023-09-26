package edu.unicauca.SivriBackendApp.core.proyecto.application.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.IntegranteProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.IntegranteProyecto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = RolProyectoDtoMapper.class)
public interface IntegrantesProyectoDtoMapper {

    @Named("IntegrantesProyectoDtoFullInfoProyecto")
    @Mapping(source = "rolProyecto", target = "rolProyecto", qualifiedByName = "RolProyectoDtoFullInfoProyecto")
    IntegranteProyectoDTO fullInfoProyecto(final IntegranteProyecto entity);

    IntegranteProyecto toModel(final IntegranteProyectoDTO dto);
}
