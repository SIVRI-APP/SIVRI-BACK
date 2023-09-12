package edu.unicauca.SivriBackendApp.core.convocatoria.application.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.response.ChecklistDTO;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Checklist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = DocumentacionDtoMapper.class)
public interface ChecklistDtoMapper {

    @Named("fullInfoConvocatoria")
    @Mapping(target = "documentacion", qualifiedByName = "fullInfoConvocatoria")
    @Mapping(target = "tipoFinanciacion", ignore = true)
    ChecklistDTO fullInfoConvocatoria(final Checklist objetoModelo);

}
