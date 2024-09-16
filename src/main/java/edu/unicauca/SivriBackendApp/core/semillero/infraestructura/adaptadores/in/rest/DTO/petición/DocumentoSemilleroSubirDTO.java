package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import lombok.Data;

@Data
public class DocumentoSemilleroSubirDTO {
    private Integer idSemillero;
    private Base64FileDto archivoAval;
    private String avalName;
    private DocumentoSemilleroSubirDocumentoDTO avalDatos;
    private Base64FileDto archivoOtro;
    private String otroName;
    private DocumentoSemilleroSubirDocumentoDTO otroDatos;

}
