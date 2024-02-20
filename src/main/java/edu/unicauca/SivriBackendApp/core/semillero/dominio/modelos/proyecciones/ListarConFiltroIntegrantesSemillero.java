package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;

import java.time.LocalDate;

public interface ListarConFiltroIntegrantesSemillero {
    String getNumeroDocumento();
    String getNombres();
    String getRolSemillero();
    EstadoIntegranteSemillero getEstado();
    String getNombrePrograma();
    LocalDate getFechaIngreso();
    LocalDate getFechaRetiro();
}
