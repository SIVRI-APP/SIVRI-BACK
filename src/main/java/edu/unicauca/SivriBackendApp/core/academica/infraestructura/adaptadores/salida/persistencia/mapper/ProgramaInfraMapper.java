package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Programa;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.entidad.ProgramaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgramaInfraMapper {

    ProgramaEntity toEntity(Programa modelo);

    Programa toModel(ProgramaEntity entidad);
}
