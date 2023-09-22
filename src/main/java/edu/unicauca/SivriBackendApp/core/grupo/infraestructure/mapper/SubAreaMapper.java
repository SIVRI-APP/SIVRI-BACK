package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.SubArea;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.SubAreaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubAreaMapper {

    SubArea obtenerModelo(final SubAreaEntity subAreaEntity);

    SubAreaEntity obtenerEntity(final SubArea subArea);

}
