package edu.unicauca.SivriBackendApp.core.usuario.application.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.application.dto.request.RegistroUsuarioDTO;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioAppMapper {

    Usuario registrarUsuario (RegistroUsuarioDTO usuarioDTO);
}