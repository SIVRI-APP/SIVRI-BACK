package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.GrupoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GrupoMapper {

    @Mapping(source = "id", target = "grupoId")
    Grupo obtenerModelo(final GrupoEntity grupoEntity);
    @Mapping(source = "grupoId",target = "id")
    GrupoEntity obtenerEntity(final Grupo grupo);

}
