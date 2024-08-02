package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.SemilleroProgramaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SemilleroProgramaDtoMapper {
    SemilleroProgramaDTO obtenerProgramasPorSemilleroId(final SemilleroPrograma objModelo);

}
