package edu.unicauca.SivriBackendApp.core.academica.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.Facultad;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.FacultadEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultadMapper {

    Facultad obtenerModelo(final FacultadEntity facultadEntity);

    FacultadEntity ObtenerEntity(final Facultad facultad);


}
