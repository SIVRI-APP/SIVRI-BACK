package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.petición.RegistroUsuarioDTO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioRestMapper {

    Usuario registrarUsuario (RegistroUsuarioDTO usuarioDTO);
}
