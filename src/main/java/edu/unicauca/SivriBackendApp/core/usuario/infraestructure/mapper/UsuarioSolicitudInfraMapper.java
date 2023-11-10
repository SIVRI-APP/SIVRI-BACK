package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioSolicitudEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioSolicitudInfraMapper {

    UsuarioSolicitudEntity toEntity(UsuarioSolicitud usuario);

    UsuarioSolicitud toModel(UsuarioSolicitudEntity usuario);
}
