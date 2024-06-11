package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudConversacion;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioSolicitudConversacionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioSolicitudConversacionInfraMapper {

    UsuarioSolicitudConversacionEntity toEntity(UsuarioSolicitudConversacion usuario);

    UsuarioSolicitudConversacion toModel(UsuarioSolicitudConversacionEntity usuario);
}
