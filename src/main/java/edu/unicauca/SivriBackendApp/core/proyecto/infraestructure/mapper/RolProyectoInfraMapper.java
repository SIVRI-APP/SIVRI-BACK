package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.RolProyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.RolProyectoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RolProyectoInfraMapper {

    @Named("RolProyectoFullInfoProyecto")
    RolProyecto fullInfoProyecto(final RolProyectoEntity entity);

    RolProyectoEntity obtenerEntity(final RolProyecto model);

}
