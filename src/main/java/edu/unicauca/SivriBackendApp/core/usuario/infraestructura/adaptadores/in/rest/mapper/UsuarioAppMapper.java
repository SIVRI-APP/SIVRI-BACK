package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest.dto.petición.RegistroUsuarioDTO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioAppMapper {

    Usuario registrarUsuario (RegistroUsuarioDTO usuarioDTO);
}
