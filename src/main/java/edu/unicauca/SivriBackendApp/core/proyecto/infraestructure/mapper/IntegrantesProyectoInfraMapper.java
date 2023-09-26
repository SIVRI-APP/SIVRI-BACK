package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.IntegranteProyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.IntegranteProyectoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = RolProyectoInfraMapper.class)
public interface IntegrantesProyectoInfraMapper {

    @Named("IntegrantesProyectoFullInfoProyecto")
    @Mapping(source = "rolProyecto", target = "rolProyecto", qualifiedByName = "RolProyectoFullInfoProyecto")
    IntegranteProyecto fullInfoProyecto(final IntegranteProyectoEntity entity);

    IntegranteProyectoEntity obtenerEntity(final IntegranteProyecto model);

}
