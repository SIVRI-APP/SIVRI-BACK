package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroEstado;

import java.time.LocalDate;

public interface ListarConFiltroSemilleros {
    Integer getSemilleroId();
    String getNombre();
    String getCorreo();
    LocalDate getFechaCreacion();
    SemilleroEstado getEstado();
}
