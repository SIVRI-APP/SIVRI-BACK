package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;

public interface ObservacionSemilleroActualizarREPO {
    Boolean actualizarObservacionSemillero(ObservacionSemillero observacionSemillero);
}
