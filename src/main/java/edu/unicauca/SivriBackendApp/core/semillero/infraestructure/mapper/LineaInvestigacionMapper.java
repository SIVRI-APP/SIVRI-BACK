package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.LineaInvestigacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LineaInvestigacionMapper {
    @Mapping(source = "semillero.id",target = "semilleroId")
    LineaInvestigacion obtenerModelo(final LineaInvestigacionEntity lineaInvestigacionEntity);
    @Mapping(source = "semilleroId",target = "semillero.id")
    LineaInvestigacionEntity obtenerEntity(final LineaInvestigacion lineaInvestigacion);
}
