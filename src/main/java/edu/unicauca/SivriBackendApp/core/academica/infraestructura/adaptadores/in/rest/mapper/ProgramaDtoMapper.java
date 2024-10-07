package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Programa;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest.DTO.respuesta.ProgramaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgramaDtoMapper {
    ProgramaDTO obtenerPrograma(final Programa programa);

}
