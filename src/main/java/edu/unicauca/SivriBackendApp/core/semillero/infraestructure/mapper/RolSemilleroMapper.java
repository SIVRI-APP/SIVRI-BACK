package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.RolGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.RolGrupoEntity;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.RolSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.RolSemilleroEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolSemilleroMapper {
    RolSemillero obtenerModelo(final RolSemilleroEntity rolSemilleroEntity);

    RolSemilleroEntity obtenerEntity(final RolSemillero rolSemillero);
}
