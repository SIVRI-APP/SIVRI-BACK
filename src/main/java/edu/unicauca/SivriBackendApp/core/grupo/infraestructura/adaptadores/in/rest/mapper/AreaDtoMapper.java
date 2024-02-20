package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Area;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.SubArea;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta.ObtenerAreasDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta.ObtenerSubAreasDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AreaDtoMapper {
    ObtenerAreasDTO dtoObtenerArea(final Area area);

    List<ObtenerSubAreasDTO> dtoObtenerSubAreas(final List<SubArea> subAreas);
}
