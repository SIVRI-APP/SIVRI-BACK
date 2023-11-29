package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioInfraMapper {

    UsuarioEntity toEntity(Usuario usuario);

    Usuario toModel(UsuarioEntity usuario);
}
