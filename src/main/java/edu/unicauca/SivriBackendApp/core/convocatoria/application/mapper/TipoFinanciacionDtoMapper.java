package edu.unicauca.SivriBackendApp.core.convocatoria.application.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.response.TipoFinanciacionDTO;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.TipoFinanciacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = ChecklistDtoMapper.class)
public interface TipoFinanciacionDtoMapper {

    @Named("fullInfoConvocatoria")
    @Mapping(target = "checklist", qualifiedByName = "fullInfoConvocatoria")
    TipoFinanciacionDTO fullInfoConvocatoria(final TipoFinanciacion objetoModelo);

}
