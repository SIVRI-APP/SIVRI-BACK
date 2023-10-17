package edu.unicauca.SivriBackendApp.core.grupo.application.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.application.dto.request.*;
import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.ObtenerGruposDTO;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface GrupoDtoMapper {
    ObtenerGruposDTO dtoObtenerGrupo(final Grupo grupo);

    List<ObtenerGruposDTO> dtoObtenerGrupos(final List<Grupo> grupos);

    Grupo crear(final GrupoCrearDTO nuevoGrupo);
    @Mapping(source = "idFacultad", target = "facultad.idFacultad")
    Grupo actualizarPorApoyo(final GrupoActualizarPorApoyoDTO nuevosDatos);
    @Mapping(source = "idFacultad",target = "facultad.idFacultad")
    Grupo actualizarPorDirector(final GrupoActualizarPorDirectorDTO nuevosDatos);
    @Mapping(source = "idFacultad",target = "facultad.idFacultad")
    Grupo actualizarGrupoFormuladoPorDirector(final GrupoFormuladoActualizarPorDirectorDTO nuevoGrupo);

    Grupo actualizarGrupoActivoPorDirector(final GrupoActivoActualizarPorDirectorDTO nuevoGrupo);

}
