package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.ObservacionSemilleroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ObservacionSemilleroMapper {
    @Mappings({
            @Mapping(source = "semillero.id",target = "semilleroId"),
            @Mapping(source = "funcionario.id",target = "funcionarioId")
    })
    ObservacionSemillero obtenerModelo(final ObservacionSemilleroEntity observacionSemilleroEntity);
    @Mappings({
            @Mapping(source = "semilleroId",target = "semillero.id"),
            @Mapping(source = "funcionarioId",target = "funcionario.id")
    })
    ObservacionSemilleroEntity obtenerEntity(final ObservacionSemillero observacionSemillero);
}
