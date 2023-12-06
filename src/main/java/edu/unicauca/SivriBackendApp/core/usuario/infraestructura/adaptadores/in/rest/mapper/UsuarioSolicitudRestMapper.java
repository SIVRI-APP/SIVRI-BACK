package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest.dto.petición.RegistroUsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioSolicitudRestMapper {

    UsuarioSolicitud registrarUsuario (RegistroUsuarioDTO usuarioDTO);
}
