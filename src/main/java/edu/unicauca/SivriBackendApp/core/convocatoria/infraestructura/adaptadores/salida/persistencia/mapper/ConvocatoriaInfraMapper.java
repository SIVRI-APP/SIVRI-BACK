package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.ConvocatoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConvocatoriaInfraMapper {

    ConvocatoriaEntity toEntity (Convocatoria modelo);

    @Mapping(target = "checklist", ignore = true)
    Convocatoria toDto (ConvocatoriaEntity entidad);

}
