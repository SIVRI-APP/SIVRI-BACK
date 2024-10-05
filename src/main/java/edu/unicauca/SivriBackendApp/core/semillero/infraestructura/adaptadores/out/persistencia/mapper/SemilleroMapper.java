package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.SemilleroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",uses = {})
public interface SemilleroMapper {
    @Mappings({
        @Mapping(source = "id",target = "semillero_Id"),
        @Mapping(source = "grupo.id",target = "grupoId"),
        //@Mapping(source = "correo",target = "correo")
      //  @Mapping(source = "integrantes",target = "integrantes")
    })
    Semillero obtenerModelo (final SemilleroEntity semilleroEntity);


    @Mappings({
            @Mapping(source = "grupoId", target = "grupo.id"),

    })
    SemilleroEntity obtenerEntity(final Semillero semillero);

}
