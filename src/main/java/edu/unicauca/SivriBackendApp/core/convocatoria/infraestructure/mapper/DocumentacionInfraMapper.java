package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Documentacion;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity.DocumentacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface DocumentacionInfraMapper {

    @Named("fullInfoConvocatoria")
    @Mapping(target = "checklist", ignore = true)
    Documentacion obtenerModeloFullInfoConvocatoria(final DocumentacionEntity entity);

    Documentacion obtenerModelo(final DocumentacionEntity entity);

    DocumentacionEntity obtenerEntity(final Documentacion model);

}
