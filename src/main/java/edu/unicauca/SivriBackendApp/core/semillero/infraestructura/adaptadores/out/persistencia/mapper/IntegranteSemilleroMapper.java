package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.IntegranteSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.SemilleroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IntegranteSemilleroMapper {

    IntegranteSemillero obtenerModelo(final IntegranteSemilleroEntity integranteSemilleroEntity);

    @Mappings({
            @Mapping(target = "usario.departamento", ignore = true),
            @Mapping(target = "usario.programa", ignore = true),
    })
    IntegranteSemilleroEntity obtenerEntity(final IntegranteSemillero integranteSemillero);

    Semillero obtenerModeloSemillero(final SemilleroEntity semilleroEntity);
}
