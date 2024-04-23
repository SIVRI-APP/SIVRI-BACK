package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Facultad;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.entidad.FacultadEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultadInfraMapper {
    FacultadEntity toEntityt(Facultad facultad);

    Facultad toModel(FacultadEntity facultad);
}
