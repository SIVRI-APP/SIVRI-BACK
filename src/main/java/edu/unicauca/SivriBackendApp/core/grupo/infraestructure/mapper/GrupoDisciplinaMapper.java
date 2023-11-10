package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoDisciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.GrupoDisciplinaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrupoDisciplinaMapper {
    GrupoDisciplina obtenerModelo(final GrupoDisciplinaEntity entity);
    GrupoDisciplinaEntity obtenerEntity(final GrupoDisciplina model);
}
