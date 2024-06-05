package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Facultad;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.entidad.FacultadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FacultadInfraMapper {

    @Mapping(target = "id", ignore = true) // Ignorar la propiedad 'id'
    Facultad toModel(FacultadEntity facultad);
}
