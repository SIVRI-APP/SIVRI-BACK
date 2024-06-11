package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Checklist;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest.dto.peticion.ChecklistDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CheckListRestMapper {

    @IterableMapping(qualifiedByName = "crearConvocatoriaFromDtoToModel")
    List<Checklist> crearConvocatoriaFromListDtoToListModel(List<ChecklistDTO> dtos);

    @Named("crearConvocatoriaFromDtoToModel")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "documentoConvocatoria.id", source = "documentoId")
    @Mapping(target = "etapaDocumento", source = "etapaDocumento")
    @Mapping(target = "responsableDocumento", source = "responsableDocumento")
    @Mapping(target = "cantidad", source = "cantidad")
    @Mapping(target = "obligatorio", source = "obligatorio")
    @Mapping(target = "completado", expression = "java(false)")
    Checklist crearConvocatoriaFromDtoToModel(ChecklistDTO dto);
}
