package edu.unicauca.SivriBackendApp.core.academica.application.mapper;

import edu.unicauca.SivriBackendApp.core.academica.application.dto.response.SemilleroProgramaDTO;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.SemilleroPrograma;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SemilleroProgramaDtoMapper {
    SemilleroProgramaDTO obtenerProgramasPorSemilleroId(final SemilleroPrograma objModelo);

}
