package edu.unicauca.SivriBackendApp.core.usuario.application.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.application.dto.response.UsuarioValidarExistenciaDTO;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioDtoMapper {

    UsuarioValidarExistenciaDTO validarExistenciaUsuario(final Usuario modelo);
}
