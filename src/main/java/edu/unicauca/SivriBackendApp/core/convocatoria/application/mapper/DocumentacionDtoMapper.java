package edu.unicauca.SivriBackendApp.core.convocatoria.application.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.response.DocumentacionDTO;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Documentacion;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface DocumentacionDtoMapper {

    @Named("fullInfoConvocatoria")
    DocumentacionDTO fullInfoConvocatoria(final Documentacion objetoModelo);

}
