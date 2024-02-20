package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;

public interface IntegranteSemilleroActualizarREPO {
    Boolean actualizar(IntegranteSemillero nuevosDatosIntegrante);
}
