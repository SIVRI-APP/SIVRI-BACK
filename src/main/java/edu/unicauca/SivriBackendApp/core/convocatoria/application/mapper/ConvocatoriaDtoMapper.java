package edu.unicauca.SivriBackendApp.core.convocatoria.application.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.request.ConvocatoriaActualizarDTO;
import edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.request.ConvocatoriaCrearDTO;
import edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.response.ConvocatoriaDTO;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TipoFinanciacionDtoMapper.class)
public interface ConvocatoriaDtoMapper {

    @Mapping(source = "tipoFinanciacion", target = "tipoFinanciacion.id")
    Convocatoria crear(final ConvocatoriaCrearDTO nuevosDatos);

    @Mapping(source = "tipoFinanciacion", target = "tipoFinanciacion.id")
    Convocatoria actualizar(final ConvocatoriaActualizarDTO nuevosDatos);


    @Mapping(source = "tipoFinanciacion", target = "tipoFinanciacion", qualifiedByName = "fullInfoConvocatoria")
    ConvocatoriaDTO fullInfoConvocatoria(final Convocatoria objetoModelo);

}
