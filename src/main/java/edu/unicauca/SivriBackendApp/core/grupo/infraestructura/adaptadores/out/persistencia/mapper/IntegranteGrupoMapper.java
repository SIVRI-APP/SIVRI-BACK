package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.IntegranteGrupoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IntegranteGrupoMapper {
    @Mapping(source = "grupo.id",target = "grupo.grupoId")
    IntegranteGrupo obtenerModelo(final IntegranteGrupoEntity integranteGrupoEntity);

   @Mappings({
            @Mapping(source = "grupo.grupoId",target = "grupo.id"),
            //@Mapping(source = "rolGrupo.id",target = "rolGrupo.id")
    })
   IntegranteGrupoEntity obtenerEntity(final IntegranteGrupo integranteGrupo);

}
