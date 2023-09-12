package edu.unicauca.SivriBackendApp.core.grupo.application.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.ObtenerRolesGrupoDTO;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.RolGrupo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolGrupoDtoMapper {
    ObtenerRolesGrupoDTO dtoObtenerRolGrupo(final RolGrupo rolGrupo);
}
