package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.mapper.TipoFinanciacionInfraMapper;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.IntegranteSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.SemilleroEntity;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IntegranteSemilleroMapper {
    @Mappings({
            @Mapping(source = "idIntegranteSemillero",target = "id"),
            @Mapping(source = "semillero.id",target = "semilleroId"),
            @Mapping(source = "usuario.numeroDocumento",target = "numeroDocumento"),

    })
    IntegranteSemillero obtenerModelo(final IntegranteSemilleroEntity integranteSemilleroEntity);
    @Mappings({
            @Mapping(source = "numeroDocumento",target = "usuario.numeroDocumento"),
            @Mapping(source = "id",target = "idIntegranteSemillero"),
            //@Mapping(source = "semilleroId",target = "semillero.id")
    })

    IntegranteSemilleroEntity obtenerEntity(final IntegranteSemillero integranteSemillero);

    Semillero obtenerModeloSemillero(final SemilleroEntity semilleroEntity);
}
