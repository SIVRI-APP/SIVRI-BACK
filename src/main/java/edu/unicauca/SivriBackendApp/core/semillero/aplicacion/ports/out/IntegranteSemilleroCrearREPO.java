package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;

public interface IntegranteSemilleroCrearREPO {
    Boolean crear(IntegranteSemillero nuevoIntegranteSemillero);
}
