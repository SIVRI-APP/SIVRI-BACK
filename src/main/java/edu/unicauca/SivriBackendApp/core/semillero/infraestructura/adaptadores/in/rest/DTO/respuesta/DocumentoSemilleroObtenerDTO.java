package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DocumentoSemilleroObtenerDTO {
    private Integer id;
    private TipoDocumentoSemillero tipo;
    private String rutaDocumento;
    private String observacion;
    private EstadoDocumentoSemillero estado;
    private LocalDate fechaRegistro;
    private Boolean documentoActivo;
    private Integer semilleroId;
}
