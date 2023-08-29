package edu.unicauca.SivriBackendApp.core.proyecto.application.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.ObtenerProyectosDataTableDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProyectoDtoMapper {
    ObtenerProyectosDataTableDTO dtoObtenerProyecto(final Proyecto proyecto);
}
