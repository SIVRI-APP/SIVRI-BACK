package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Area;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.AreaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AreaMapper {
    Area obtenerModelo(final AreaEntity areaEntity);
    AreaEntity obtenerEntity(final Area area);
}
