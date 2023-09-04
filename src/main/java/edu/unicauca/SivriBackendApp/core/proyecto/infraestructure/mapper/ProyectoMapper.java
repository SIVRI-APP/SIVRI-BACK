package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.ProyectoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProyectoMapper {
    Proyecto obtenerModelo(final ProyectoEntity proyectoEntity);

    ProyectoEntity obtenerEntity(final Proyecto proyecto);

}
