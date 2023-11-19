package edu.unicauca.SivriBackendApp.core.grupo.application.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.ObtenerAreasDTO;
import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.ObtenerSubAreasDTO;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Area;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.SubArea;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AreaDtoMapper {
    ObtenerAreasDTO dtoObtenerArea(final Area area);

    List<ObtenerSubAreasDTO> dtoObtenerSubAreas(final List<SubArea> subAreas);
}
