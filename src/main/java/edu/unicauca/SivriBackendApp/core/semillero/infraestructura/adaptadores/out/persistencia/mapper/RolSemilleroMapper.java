package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.RolSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.RolSemilleroEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolSemilleroMapper {
    RolSemillero obtenerModelo(final RolSemilleroEntity rolSemilleroEntity);

    RolSemilleroEntity obtenerEntity(final RolSemillero rolSemillero);
}
