package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioSolicitudObservacionesEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioSolicitudObservacionesInfraMapper {

    UsuarioSolicitudObservacionesEntity toEntity(UsuarioSolicitudObservaciones usuario);

    UsuarioSolicitudObservaciones toModel(UsuarioSolicitudObservacionesEntity usuario);
}
