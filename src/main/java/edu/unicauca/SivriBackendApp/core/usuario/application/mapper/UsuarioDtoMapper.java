package edu.unicauca.SivriBackendApp.core.usuario.application.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.application.dto.request.SolicitudCreacionUsuarioDTO;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioDtoMapper {

    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "contraseña", ignore = true)
    @Mapping(target = "rolesDeUsuario", ignore = true)
    Usuario solicitudCreacionDeUsuario (SolicitudCreacionUsuarioDTO nuevoUsuario);
}
