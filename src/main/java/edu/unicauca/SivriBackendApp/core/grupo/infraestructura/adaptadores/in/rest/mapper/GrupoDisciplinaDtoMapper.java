package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoDisciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta.GrupoDisciplinaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface GrupoDisciplinaDtoMapper {
    @Mappings({
            @Mapping(source = "grupo.id",target = "grupo.grupoId"),
            @Mapping(source = "grupo.facultad.id",target = "grupo.facultad.id")

    })
    GrupoDisciplinaDTO obtenerDisciplinasPorGrupoId(final GrupoDisciplina objModelo);
}
