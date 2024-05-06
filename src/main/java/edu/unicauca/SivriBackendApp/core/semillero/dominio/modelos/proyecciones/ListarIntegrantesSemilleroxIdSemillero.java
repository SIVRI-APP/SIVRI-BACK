package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones;

import java.time.LocalDate;

public interface ListarIntegrantesSemilleroxIdSemillero {
    String getNumeroDocumento();
    String getNombreCompleto();
    String getRolSemillero();
    String getEstado();
    String getPrograma();
    LocalDate getFechaIngreso();
    LocalDate getFechaRetiro();
}
