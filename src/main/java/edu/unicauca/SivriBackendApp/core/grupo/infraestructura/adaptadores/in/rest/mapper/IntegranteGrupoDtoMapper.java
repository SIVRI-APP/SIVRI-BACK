package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.petición.IntegranteGrupoActualizarDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.petición.IntegranteGrupoCrearDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta.IntegranteGrupoObtenerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IntegranteGrupoDtoMapper {

    IntegranteGrupoObtenerDTO obtenerIntegrantesGrupo(final IntegranteGrupo integrantesGrupo);
    @Mapping(source = "usuario",target = "usuario")
    IntegranteGrupoObtenerDTO obtenerIntegranteGrupo(final IntegranteGrupo integranteGrupo);
    @Mappings({
       // @Mapping(source = "numeroDocumento",target = "usuario.numeroDocumento"),
        @Mapping(source = "rolGrupoId",target = "rolGrupo.id"),
        @Mapping(source = "grupoId",target = "grupo.grupoId")
    })
    IntegranteGrupo asociarIntegranteGrupo(final IntegranteGrupoCrearDTO nuevosDatos);

    @Mappings({
            @Mapping(source = "rolGrupoId",target = "rolGrupo.id"),
            //@Mapping(source = "grupoId",target = "grupo.id")
    })
    IntegranteGrupo actualizar(final IntegranteGrupoActualizarDTO nuevosDatos);
}
