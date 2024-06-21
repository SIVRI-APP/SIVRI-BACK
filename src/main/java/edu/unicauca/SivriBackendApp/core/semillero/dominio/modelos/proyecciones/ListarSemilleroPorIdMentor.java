package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroEstado;

public interface ListarSemilleroPorIdMentor {
    Integer getSemilleroId();
    String getNombre();
    SemilleroEstado getEstado();
}
