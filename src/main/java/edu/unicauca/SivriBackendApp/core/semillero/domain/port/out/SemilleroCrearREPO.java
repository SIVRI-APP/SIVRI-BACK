package edu.unicauca.SivriBackendApp.core.semillero.domain.port.out;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;

public interface SemilleroCrearREPO {
    Boolean crear(Semillero semillero, IntegranteSemillero integranteSemillero);
}
