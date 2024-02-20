package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.DocumentoSemilleroActualizarDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.DocumentoSemilleroObtenerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentoSemilleroDtoMapper {
    DocumentoSemilleroObtenerDTO obtenerDocumentoSemillero(final DocumentoSemillero obtenerModelo);
    DocumentoSemillero actualizarDocumento(final DocumentoSemilleroActualizarDTO documentonuevo);
}
