package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Area;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.AreaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.IntegranteGrupoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IntegranteGrupoMapper {
    //@Mapping(source = "grupo",target = "grupoId")
    IntegranteGrupo obtenerModelo(final IntegranteGrupoEntity integranteGrupoEntity);

   @Mappings({
            @Mapping(source = "grupo.grupoId",target = "grupo.id"),
            //@Mapping(source = "rolGrupo.id",target = "rolGrupo.id")
    })
    IntegranteGrupoEntity obtenerEntity(final IntegranteGrupo integranteGrupo);

}
