package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.GrupoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface GrupoMapper {

    @Mappings(
            {@Mapping(source = "id", target = "grupoId"),
             @Mapping(source = "departamento", target = "departamento")
            }
    )
    Grupo obtenerModelo(final GrupoEntity grupoEntity);
    @Mapping(source = "grupoId",target = "id")
    GrupoEntity obtenerEntity(final Grupo grupo);

}
