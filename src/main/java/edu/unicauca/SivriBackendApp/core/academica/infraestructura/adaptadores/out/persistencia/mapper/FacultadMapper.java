package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Facultad;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.FacultadEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultadMapper {

    Facultad obtenerModelo(final FacultadEntity facultadEntity);

    FacultadEntity ObtenerEntity(final Facultad facultad);


}
