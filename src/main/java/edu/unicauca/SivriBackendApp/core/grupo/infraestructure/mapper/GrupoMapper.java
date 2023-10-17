package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.GrupoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GrupoMapper {

    @Mapping(source = "id", target = "grupoId")
    Grupo obtenerModelo(final GrupoEntity grupoEntity);
    @Mapping(source = "grupoId",target = "id")
    GrupoEntity obtenerEntity(final Grupo grupo);

}
