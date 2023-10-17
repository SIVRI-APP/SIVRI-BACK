package edu.unicauca.SivriBackendApp.core.semillero.application.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.application.mapper.AreaDtoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.application.mapper.GrupoDtoMapper;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.request.SemilleroActualizarEstadoDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.request.SemilleroActualizarPorApoyoDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.request.SemilleroActualizarPorMentorDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.request.SemilleroCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.response.SemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

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
