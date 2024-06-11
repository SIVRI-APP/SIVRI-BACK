package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioInfraMapper {

    @Mappings({
            @Mapping(source = "programa.id" , target = "programa.id"),
            @Mapping(target = "programa.departamento", ignore = true)
    })
    UsuarioEntity toEntity(Usuario usuario);

    @Mappings({
            @Mapping(source = "programa.id" , target = "programa.id"),
            @Mapping(target = "programa.departamento", ignore = true)
    })
    Usuario toModel(UsuarioEntity usuario);
}
