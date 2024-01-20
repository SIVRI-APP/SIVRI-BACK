package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.CompromisoSemillero;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.CompromisoSemilleroEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompromisoSemilleroMapper {
    CompromisoSemillero obtenerModelo(final CompromisoSemilleroEntity planTrabajoEntity);

    CompromisoSemilleroEntity obtenerEntity(final CompromisoSemillero planTrabajo);
}
