package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.RolGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.RolGrupoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolGrupoMapper {

    RolGrupo obtenerModelo(final RolGrupoEntity rolGrupoEntity);

    RolGrupoEntity obtenerEntity(final RolGrupo rolGrupo);

}
