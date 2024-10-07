package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Facultad;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest.DTO.respuesta.FacultadDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultadDtoMapper {

    FacultadDTO obtenerFacultad(final Facultad facultad);



}
