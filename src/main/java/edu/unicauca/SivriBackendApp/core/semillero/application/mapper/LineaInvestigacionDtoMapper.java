package edu.unicauca.SivriBackendApp.core.semillero.application.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.application.dto.response.LineaInvestigacionObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LineaInvestigacionDtoMapper {
    LineaInvestigacionObtenerDTO obtenerLineasInvestigacion(final LineaInvestigacion obtenerModelo);
}
