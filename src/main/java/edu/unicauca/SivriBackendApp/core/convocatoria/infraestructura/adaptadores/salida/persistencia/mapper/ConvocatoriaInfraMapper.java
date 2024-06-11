package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.ConvocatoriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConvocatoriaInfraMapper {

    ConvocatoriaEntity toEntity (Convocatoria modelo);

    Convocatoria toDto (ConvocatoriaEntity entidad);
}
