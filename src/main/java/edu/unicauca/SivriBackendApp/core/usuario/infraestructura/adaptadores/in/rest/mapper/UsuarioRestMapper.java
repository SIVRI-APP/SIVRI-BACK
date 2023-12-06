package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest.dto.petición.RegistroUsuarioDTO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioRestMapper {

    Usuario registrarUsuario (RegistroUsuarioDTO usuarioDTO);
}
