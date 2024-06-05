package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioSolicitudEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioSolicitudInfraMapper {

    @Mappings({
        @Mapping(source = "programa.id" , target = "programa.id"),
        @Mapping(target = "programa.departamento", ignore = true)
    })
    UsuarioSolicitudEntity toEntity(UsuarioSolicitud usuario);

    @Mappings({
            @Mapping(source = "programa.id" , target = "programa.id"),
            @Mapping(target = "programa.departamento", ignore = true)
    })
    UsuarioSolicitud toModel(UsuarioSolicitudEntity usuario);
}
