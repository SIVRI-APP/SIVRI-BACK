package edu.unicauca.SivriBackendApp.core.semillero.application.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.application.mapper.TipoFinanciacionDtoMapper;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.request.IntegranteSemilleroActualizarDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.request.IntegranteSemilleroCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.response.IntegranteSemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.response.SemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IntegranteSemilleroDtoMapper {
    @Mapping(source = "rolSemilleroId",target = "rolSemillero.id")
    IntegranteSemillero crear(final IntegranteSemilleroCrearDTO nuevoIntegranteSemillero);
    @Mapping(source = "rolSemilleroId",target = "rolSemillero.id")
    IntegranteSemillero actualizar(final IntegranteSemilleroActualizarDTO nuevoIntegrante);
    IntegranteSemilleroObtenerDTO obtenerDtoIntegranteSemillero(final IntegranteSemillero integranteSemillero);
    SemilleroObtenerDTO dtoObtenerSemillero(final Semillero semillero);

}
