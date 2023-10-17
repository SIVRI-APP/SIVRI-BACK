package edu.unicauca.SivriBackendApp.core.grupo.application.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.application.dto.request.IntegranteGrupoActualizarDTO;
import edu.unicauca.SivriBackendApp.core.grupo.application.dto.request.IntegranteGrupoCrearDTO;
import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.IntegranteGrupoObtenerDTO;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IntegranteGrupoDtoMapper {

    IntegranteGrupoObtenerDTO obtenerIntegrantesGrupo(final IntegranteGrupo integrantesGrupo);

    IntegranteGrupoObtenerDTO obtenerIntegranteGrupo(final IntegranteGrupo integranteGrupo);
    @Mappings({
        @Mapping(source = "numeroDocumento",target = "usuario.numeroDocumento"),
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
