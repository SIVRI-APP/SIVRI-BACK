package edu.unicauca.SivriBackendApp.core.grupo.application.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.ObtenerAreasDTO;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Area;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AreaDtoMapper {
    ObtenerAreasDTO dtoObtenerArea(final Area area);
}
