package edu.unicauca.SivriBackendApp.core.academica.application.mapper;

import edu.unicauca.SivriBackendApp.core.academica.application.dto.response.FacultadDTO;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.Facultad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultadDtoMapper {

    FacultadDTO obtenerFacultad(final Facultad facultad);



}
