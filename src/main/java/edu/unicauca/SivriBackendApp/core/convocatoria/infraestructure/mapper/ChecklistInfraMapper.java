package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Checklist;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity.ChecklistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = DocumentacionInfraMapper.class)
public interface ChecklistInfraMapper {

    @Named("fullInfoConvocatoria")
    @Mapping(target = "tipoFinanciacion", ignore = true)
    @Mapping(target = "documentacion", qualifiedByName = "fullInfoConvocatoria")
    Checklist obtenerModeloFullInfoConvocatoria(final ChecklistEntity entity);

    Checklist obtenerModelo(final ChecklistEntity entity);

    ChecklistEntity obtenerEntity(final Checklist model);

}
