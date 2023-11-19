package edu.unicauca.SivriBackendApp.core.grupo.application.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.GrupoDisciplinaDTO;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoDisciplina;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface GrupoDisciplinaDtoMapper {
    @Mappings({
            @Mapping(source = "grupo.id",target = "grupo.grupoId"),
            @Mapping(source = "grupo.facultad.idFacultad",target = "grupo.facultad.id")

    })
    GrupoDisciplinaDTO obtenerDisciplinasPorGrupoId(final GrupoDisciplina objModelo);
}
