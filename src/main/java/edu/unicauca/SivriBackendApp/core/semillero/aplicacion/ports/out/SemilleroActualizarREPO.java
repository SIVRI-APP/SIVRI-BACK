package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out;


import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;

public interface SemilleroActualizarREPO {

    Boolean actualizarPorApoyo(Semillero nuevoSemillero);
    Boolean actualizarEstadoSemillero(Semillero nuevoEstadoSemillero);
    Boolean actualizarPorMentor(Semillero nuevoSemillero);
}
