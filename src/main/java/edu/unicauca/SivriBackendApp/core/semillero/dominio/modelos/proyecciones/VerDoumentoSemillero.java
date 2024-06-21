package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroEstado;

import java.time.LocalDate;

public interface VerDoumentoSemillero {
    String getNombre();
    LocalDate getFechaCreacion();
    SemilleroEstado getEstadoSemillero();
    String getObservacion();
    EstadoDocumentoSemillero getEstadoDocumento();

}
