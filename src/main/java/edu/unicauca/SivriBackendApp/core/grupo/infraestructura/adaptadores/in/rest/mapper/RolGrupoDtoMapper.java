package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.RolGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta.ObtenerRolesGrupoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolGrupoDtoMapper {
     ObtenerRolesGrupoDTO dtoObtenerRolGrupo(final RolGrupo rolGrupo);
}
