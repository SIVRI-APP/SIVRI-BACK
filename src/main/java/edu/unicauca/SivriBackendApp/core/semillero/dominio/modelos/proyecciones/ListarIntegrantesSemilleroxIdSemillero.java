package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones;

import java.time.LocalDate;

public interface ListarIntegrantesSemilleroxIdSemillero {
    Integer getIdIntegranteSemillero();
    String getNumeroDocumento();
    String getNombreCompleto();
    String getRolSemillero();
    String getEstado();
    LocalDate getFechaIngreso();
}
