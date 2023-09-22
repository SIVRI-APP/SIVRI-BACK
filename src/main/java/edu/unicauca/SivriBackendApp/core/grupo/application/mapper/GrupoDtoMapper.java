package edu.unicauca.SivriBackendApp.core.grupo.application.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.ObtenerGruposDTO;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GrupoDtoMapper {
    ObtenerGruposDTO dtoObtenerGrupo(final Grupo grupo);

    List<ObtenerGruposDTO> dtoObtenerGrupos(final List<Grupo> grupos);
}
