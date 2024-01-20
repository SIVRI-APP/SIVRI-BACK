package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper.GrupoDtoMapper;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.SemilleroActualizarEstadoDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.SemilleroActualizarPorApoyoDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.SemilleroActualizarPorMentorDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.SemilleroCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.SemilleroObtenerDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {GrupoDtoMapper.class})
public interface SemilleroDtoMapper {

    SemilleroObtenerDTO dtoObtenerSemillero(final Semillero semillero);
   //@Mapping(source = "grupoId",target = "grupo.id")
    List<SemilleroObtenerDTO> dtoObtenerSemilleros(final List<Semillero> semilleros);
    Semillero crear(final SemilleroCrearDTO nuevoSemillero);

    Semillero actualizarPorApoyo(final SemilleroActualizarPorApoyoDTO actualizarSemilleroPorApoyoDTO);
    Semillero actualizarEstadoSemillero(final SemilleroActualizarEstadoDTO actualizarEstadoSemilleroDTO);
    Semillero actualizarPorMentor(final SemilleroActualizarPorMentorDTO actualizarSemilleroPoMentor);
}
