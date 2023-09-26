package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity.ConvocatoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = TipoFinanciacionInfraMapper.class)
public interface ConvocatoriaInfraMapper {

    @Mapping(source = "tipoFinanciacion", target = "tipoFinanciacion", qualifiedByName = "fullInfoConvocatoria")
    Convocatoria fullInfoConvocatoria(final ConvocatoriaEntity entity);

    ConvocatoriaEntity obtenerEntity(final Convocatoria model);

    @Named("obtnerModeloParaProyecto")
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "tipoFinanciacion", ignore = true)
    Convocatoria obtnerModeloParaProyecto(final ConvocatoriaEntity model);

}
