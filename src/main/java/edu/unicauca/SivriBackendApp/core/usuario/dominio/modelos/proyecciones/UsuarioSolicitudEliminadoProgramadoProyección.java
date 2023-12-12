package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones;

import java.time.LocalDate;

public interface UsuarioSolicitudEliminadoProgramadoProyección {
    Long getId();
    LocalDate getFechaObservación();
    LocalDate getFechaLimite();
}
