package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemilleroDatos;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.DocumentoSemilleroActualizarDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.DocumentoSemilleroSubirDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.DocumentoSemilleroSubirDocumentoDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.DocumentoSemilleroObtenerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentoSemilleroDtoMapper {
    DocumentoSemilleroObtenerDTO obtenerDocumentoSemillero(final DocumentoSemillero obtenerModelo);
    DocumentoSemillero actualizarDocumento(final DocumentoSemilleroActualizarDTO documentonuevo);
    @Mapping(source = "idSemillero",target = "semillero.semilleroId")
    DocumentoSemillero obtenerDocumentoxSubir(final DocumentoSemilleroSubirDTO documentoSemilleroSUbirDto);
    DocumentoSemilleroDatos obtenerDatosDocumentos(final DocumentoSemilleroSubirDocumentoDTO documentosDto);

}
