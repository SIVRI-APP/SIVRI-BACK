package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest.dto.petición.CrearConvocatoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ConvocatoriaRestMapper {

    @Named("crearConvocatoria")
    @Mapping(source = "tipoConvocatoriaId", target = "tipoConvocatoria.id")
    Convocatoria crearConvocatoria (CrearConvocatoriaDTO convocatoria);
}
