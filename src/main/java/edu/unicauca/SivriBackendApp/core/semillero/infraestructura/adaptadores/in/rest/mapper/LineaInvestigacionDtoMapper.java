package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.LineaInvestigacionActualizarDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.LineaInvestigacionCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.LineaInvestigacionObtenerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LineaInvestigacionDtoMapper {
    LineaInvestigacion actualizarLinea(final LineaInvestigacionActualizarDTO nuevaLInea);
    LineaInvestigacion asociarLineaASemillero(final LineaInvestigacionCrearDTO lineaInvestigacionCrearDTO);
    LineaInvestigacionObtenerDTO obtenerLineasInvestigacion(final LineaInvestigacion obtenerModelo);
}
