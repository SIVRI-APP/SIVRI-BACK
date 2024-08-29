package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.DocumentoSemilleroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface DocumentoSemilleroMapper {

    DocumentoSemillero obtenerModelo(final DocumentoSemilleroEntity documentoSemilleroEntity);
    @Mapping(source = "documentoActivo",target = "documentoActivo")
    DocumentoSemilleroEntity obtenerEntity(final DocumentoSemillero documentoSemillero);

}
