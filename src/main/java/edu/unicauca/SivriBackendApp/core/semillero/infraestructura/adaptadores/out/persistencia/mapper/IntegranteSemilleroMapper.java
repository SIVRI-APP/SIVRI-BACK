package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.IntegranteSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.SemilleroEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IntegranteSemilleroMapper {

    IntegranteSemillero obtenerModelo(final IntegranteSemilleroEntity integranteSemilleroEntity);

    IntegranteSemilleroEntity obtenerEntity(final IntegranteSemillero integranteSemillero);

    Semillero obtenerModeloSemillero(final SemilleroEntity semilleroEntity);
}
