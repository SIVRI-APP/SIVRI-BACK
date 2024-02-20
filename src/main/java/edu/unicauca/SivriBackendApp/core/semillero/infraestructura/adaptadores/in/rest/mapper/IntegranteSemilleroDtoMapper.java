package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.IntegranteSemilleroActualizarDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.IntegranteSemilleroCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.IntegranteSemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.SemilleroObtenerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IntegranteSemilleroDtoMapper {
    @Mappings({
            @Mapping(source = "rolSemilleroId",target = "rolSemillero.id"),
            @Mapping(source = "tipoDocumento",target = "usuario.tipoDocumento"),
            @Mapping(source = "numeroDocumento",target = "usuario.numeroDocumento"),
            @Mapping(source = "semilleroId", target = "semillero.semilleroId")
    })
    IntegranteSemillero crear(final IntegranteSemilleroCrearDTO nuevoIntegranteSemillero);
    @Mapping(source = "rolSemilleroId",target = "rolSemillero.id")
    IntegranteSemillero actualizar(final IntegranteSemilleroActualizarDTO nuevoIntegrante);
    @Mappings({
            @Mapping(source = "semillero.id",target = "semilleroId"),
            @Mapping(source = "usuario.id", target = "usuarioId")

    })
    IntegranteSemilleroObtenerDTO obtenerDtoIntegranteSemillero(final IntegranteSemillero integranteSemillero);
    SemilleroObtenerDTO dtoObtenerSemillero(final Semillero semillero);

}
