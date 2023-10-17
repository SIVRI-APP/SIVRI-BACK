package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.application.mapper.GrupoDtoMapper;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.SemilleroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",uses = {})
public interface SemilleroMapper {
    @Mappings({
        @Mapping(source = "id",target = "semilleroId"),
        @Mapping(source = "grupo.id",target = "grupoId"),
        @Mapping(source = "integrantes",target = "integrantes")
    })
    Semillero obtenerModelo (final SemilleroEntity semilleroEntity);


    @Mappings({
            @Mapping(source = "grupoId", target = "grupo.id"),

    })
    SemilleroEntity obtenerEntity(final Semillero semillero);

}
