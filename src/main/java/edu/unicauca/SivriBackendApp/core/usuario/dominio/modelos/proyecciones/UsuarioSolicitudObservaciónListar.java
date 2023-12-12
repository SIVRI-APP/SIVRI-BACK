package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones;

import java.time.LocalDate;

public interface UsuarioSolicitudObservaciónListar {
    Long getId();
    String getObservación();
    LocalDate getFechaObservación();
}
