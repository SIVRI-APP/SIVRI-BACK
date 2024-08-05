package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DocumentoSemillero {

    private Integer id;
    private TipoDocumentoSemillero tipo;
    private String rutaDocumento;
    private String observacion;
    private EstadoDocumentoSemillero estado;
    private LocalDate fechaRegistro;
    private Semillero semillero;
}
