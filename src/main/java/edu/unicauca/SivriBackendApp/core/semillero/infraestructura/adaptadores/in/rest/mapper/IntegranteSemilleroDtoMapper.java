package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.IntegranteSemilleroActualizarDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.IntegranteSemilleroCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.IntegranteSemilleroCrearMentorDto;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.IntegranteSemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.SemilleroObtenerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IntegranteSemilleroDtoMapper {
    @Mappings({
            @Mapping(source = "rolSemilleroId",target = "rolSemillero.id"),
            @Mapping(source = "usuarioId",target = "usuario.id"),
            @Mapping(source = "semilleroId", target = "semillero.semilleroId")
    })
    IntegranteSemillero crear(final IntegranteSemilleroCrearDTO nuevoIntegranteSemillero);
    @Mappings({
            @Mapping(source = "rolSemilleroId",target = "rolSemillero.id"),
            @Mapping(source = "usuarioId", target = "usuario.id"),
            @Mapping(source = "semilleroId", target = "semillero.semilleroId")
    })
    IntegranteSemillero crearMentor(final IntegranteSemilleroCrearMentorDto nuevoIntegranteSemillero);

    @Mapping(source = "rolSemilleroId",target = "rolSemillero.id")
    IntegranteSemillero actualizar(final IntegranteSemilleroActualizarDTO nuevoIntegrante);
    @Mappings({
            @Mapping(source = "semillero.id",target = "semillero.semilleroId"),
            @Mapping(source = "usuario", target = "usuario")

    })
    IntegranteSemilleroObtenerDTO obtenerDtoIntegranteSemillero(final IntegranteSemillero integranteSemillero);
    SemilleroObtenerDTO dtoObtenerSemillero(final Semillero semillero);

}
