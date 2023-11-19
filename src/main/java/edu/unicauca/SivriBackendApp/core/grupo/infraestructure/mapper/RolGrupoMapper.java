package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.RolGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.RolGrupoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolGrupoMapper {

    RolGrupo obtenerModelo(final RolGrupoEntity rolGrupoEntity);

    RolGrupoEntity obtenerEntity(final RolGrupo rolGrupo);

}
