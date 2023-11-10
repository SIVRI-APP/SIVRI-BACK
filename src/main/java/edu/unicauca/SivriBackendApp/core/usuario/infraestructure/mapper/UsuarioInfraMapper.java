package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioInfraMapper {
    UsuarioEntity toEntity(Usuario usuario);

    Usuario toModel(UsuarioEntity usuario);
}
