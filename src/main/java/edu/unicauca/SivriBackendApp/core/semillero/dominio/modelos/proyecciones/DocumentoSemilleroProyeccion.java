package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

public interface DocumentoSemilleroProyeccion {
    Integer getId();
    TipoDocumentoSemillero getTipo();
    String getRutaDocumento();
    String getObservacion();
    EstadoDocumentoSemillero getEstado();
    LocalDate getFechaRegistro();
    Boolean getDocumentoActivo();
    Integer getSemilleroId();
}
