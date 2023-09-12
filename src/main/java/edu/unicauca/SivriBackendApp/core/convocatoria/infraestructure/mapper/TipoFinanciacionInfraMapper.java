package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity.TipoFinanciacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = ChecklistInfraMapper.class)
public interface TipoFinanciacionInfraMapper {

    @Named("fullInfoConvocatoria")
    @Mapping(target = "checklist", qualifiedByName = "fullInfoConvocatoria")
    TipoFinanciacion obtenerModeloFullInfoConvocatoria(final TipoFinanciacionEntity entity);

    TipoFinanciacion obtenerModelo(final TipoFinanciacionEntity entity);

    TipoFinanciacionEntity obtenerEntity(final TipoFinanciacion model);

}
