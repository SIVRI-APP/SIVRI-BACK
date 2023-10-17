package edu.unicauca.SivriBackendApp.core.semillero.domain.port.out;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;

public interface SemilleroActualizarREPO {

    Boolean actualizarPorApoyo(Semillero nuevoSemillero);
    Boolean actualizarEstadoSemillero(Semillero nuevoEstadoSemillero);
    Boolean actualizarPorMentor(Semillero nuevoSemillero);
}
