package edu.unicauca.SivriBackendApp.core.academica.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.Programa;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.ProgramaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgramaMapper {
    Programa obtenerModelo(final ProgramaEntity entity);

    ProgramaEntity obtenerEntity(final Programa model);
}
