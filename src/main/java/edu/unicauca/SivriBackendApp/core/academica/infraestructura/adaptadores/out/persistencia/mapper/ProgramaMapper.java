package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Programa;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.ProgramaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgramaMapper {
    Programa obtenerModelo(final ProgramaEntity entity);

    ProgramaEntity obtenerEntity(final Programa model);
}
