package edu.unicauca.SivriBackendApp.core.semillero.application.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.application.dto.request.LineaInvestigacionActualizarDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.request.LineaInvestigacionCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.response.LineaInvestigacionObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LineaInvestigacionDtoMapper {
    LineaInvestigacion actualizarLinea(final LineaInvestigacionActualizarDTO nuevaLInea);
    LineaInvestigacion asociarLineaASemillero(final LineaInvestigacionCrearDTO lineaInvestigacionCrearDTO);
    LineaInvestigacionObtenerDTO obtenerLineasInvestigacion(final LineaInvestigacion obtenerModelo);
}
