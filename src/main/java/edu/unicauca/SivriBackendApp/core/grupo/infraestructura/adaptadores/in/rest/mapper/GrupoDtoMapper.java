package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.petición.GrupoActualizarPorApoyoDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.petición.GrupoActualizarPorDirectorDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.petición.GrupoCrearDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta.ObtenerGruposDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface GrupoDtoMapper {
    @Mappings({
            @Mapping(source = "facultad.idFacultad",target = "facultad.id"),
            @Mapping(source = "departamento", target = "departamento")
    })
    ObtenerGruposDTO dtoObtenerGrupo(final Grupo grupo);

    List<ObtenerGruposDTO> dtoObtenerGrupos(final List<Grupo> grupos);

    Grupo crear(final GrupoCrearDTO nuevoGrupo);
    @Mapping(source = "idFacultad", target = "facultad.idFacultad")
    Grupo actualizarPorApoyo(final GrupoActualizarPorApoyoDTO nuevosDatos);
    @Mapping(source = "idFacultad",target = "facultad.idFacultad")
    Grupo actualizarPorDirector(final GrupoActualizarPorDirectorDTO nuevosDatos);
    /*@Mapping(source = "idFacultad",target = "facultad.idFacultad")
    Grupo actualizarGrupoFormuladoPorDirector(final GrupoFormuladoActualizarPorDirectorDTO nuevoGrupo);

    Grupo actualizarGrupoActivoPorDirector(final GrupoActivoActualizarPorDirectorDTO nuevoGrupo);
*/
}
