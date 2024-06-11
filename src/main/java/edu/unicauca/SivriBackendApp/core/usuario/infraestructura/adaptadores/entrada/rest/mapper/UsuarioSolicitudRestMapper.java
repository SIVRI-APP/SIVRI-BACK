package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada.RegistroUsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioSolicitudRestMapper {

    @Mappings({
            @Mapping(source = "programaId", target = "programa.id")
    })
    UsuarioSolicitud registrarUsuario(RegistroUsuarioDTO usuarioDTO);
}
