package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.UsuarioSolicitudEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioSolicitudInfraMapper {

    UsuarioSolicitudEntity toEntity(UsuarioSolicitud usuario);

    UsuarioSolicitud toModel(UsuarioSolicitudEntity usuario);
}
