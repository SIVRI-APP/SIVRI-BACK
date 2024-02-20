package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;

public interface ObservacionSemilleroCrearREPO {
    Boolean crear(ObservacionSemillero nuevaObservacion);
}
