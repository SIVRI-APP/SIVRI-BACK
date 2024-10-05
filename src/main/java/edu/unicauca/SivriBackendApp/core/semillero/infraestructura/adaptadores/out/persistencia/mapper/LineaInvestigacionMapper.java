package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.LineaInvestigacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LineaInvestigacionMapper {
    @Mapping(source = "semillero.id",target = "semillero_Id")
    LineaInvestigacion obtenerModelo(final LineaInvestigacionEntity lineaInvestigacionEntity);
    @Mapping(source = "semillero_Id",target = "semillero.id")
    LineaInvestigacionEntity obtenerEntity(final LineaInvestigacion lineaInvestigacion);
}
