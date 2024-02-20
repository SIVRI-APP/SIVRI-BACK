package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones;

import java.time.LocalDate;

public interface ListarObservacionesPorIdSemillero {
    String getObservacion();
    String getUsuario();
    LocalDate getFecha();

}
