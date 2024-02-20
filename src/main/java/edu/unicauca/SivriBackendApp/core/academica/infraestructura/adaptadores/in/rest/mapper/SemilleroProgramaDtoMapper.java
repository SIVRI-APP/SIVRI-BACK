package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest.DTO.respuesta.SemilleroProgramaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SemilleroProgramaDtoMapper {
    SemilleroProgramaDTO obtenerProgramasPorSemilleroId(final SemilleroPrograma objModelo);

}
