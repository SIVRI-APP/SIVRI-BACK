package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad.UsuarioSolicitudObservacionesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FuncionarioInfraMapper.class})
public interface UsuarioSolicitudObservacionesInfraMapper {

    @Mapping(source = "funcionario", target = "funcionario", qualifiedByName = "toEntity")
    UsuarioSolicitudObservacionesEntity toEntity(UsuarioSolicitudObservaciones observación);

    @Mapping(source = "funcionario", target = "funcionario", qualifiedByName = "toModel")
    UsuarioSolicitudObservaciones toModel(UsuarioSolicitudObservacionesEntity observación);
}
