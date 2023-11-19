package edu.unicauca.SivriBackendApp.core.academica.application.mapper;

import edu.unicauca.SivriBackendApp.core.academica.application.dto.response.ProgramaDTO;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.Programa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgramaDtoMapper {
    ProgramaDTO obtenerPrograma(final Programa programa);

}
