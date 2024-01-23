package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.ConvocatoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ConvocatoriaInfraMapper {
    @Named("crearConvocatoria")
    @Mapping(source = "tipoConvocatoria.id", target = "tipoConvocatoriaEntity.id")
    ConvocatoriaEntity crearConvocatoria (Convocatoria modelo);
}
