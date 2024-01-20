package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.DocumentoSemilleroEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentoSemilleroMapper {

    DocumentoSemillero obtenerModelo(final DocumentoSemilleroEntity documentoSemilleroEntity);
    DocumentoSemilleroEntity obtenerEntity(final DocumentoSemillero documentoSemillero);

}
