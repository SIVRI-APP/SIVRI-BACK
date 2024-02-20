package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.RolSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.RolesSemilleroObtenerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolSemilleroDtoMapper {
    RolesSemilleroObtenerDTO dtoObtenerRolSemillero(final RolSemillero rolSemillero);
}
