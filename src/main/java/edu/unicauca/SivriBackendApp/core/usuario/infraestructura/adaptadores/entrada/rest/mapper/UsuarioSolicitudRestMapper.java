package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.petición.RegistroUsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioSolicitudRestMapper {

    UsuarioSolicitud registrarUsuario (RegistroUsuarioDTO usuarioDTO);
}
