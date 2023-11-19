package edu.unicauca.SivriBackendApp.core.semillero.application.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.application.dto.response.RolesSemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.RolSemillero;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolSemilleroDtoMapper {
    RolesSemilleroObtenerDTO dtoObtenerRolSemillero(final RolSemillero rolSemillero);
}
