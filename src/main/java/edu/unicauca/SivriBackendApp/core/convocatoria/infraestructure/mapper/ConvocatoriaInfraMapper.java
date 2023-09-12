package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity.ConvocatoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TipoFinanciacionInfraMapper.class)
public interface ConvocatoriaInfraMapper {

    @Mapping(source = "tipoFinanciacion", target = "tipoFinanciacion", qualifiedByName = "fullInfoConvocatoria")
    Convocatoria obtenerModelo(final ConvocatoriaEntity entity);

    ConvocatoriaEntity obtenerEntity(final Convocatoria model);

}
