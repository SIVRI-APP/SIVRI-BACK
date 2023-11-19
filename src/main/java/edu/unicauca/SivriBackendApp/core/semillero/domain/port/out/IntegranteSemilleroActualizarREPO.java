package edu.unicauca.SivriBackendApp.core.semillero.domain.port.out;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;

public interface IntegranteSemilleroActualizarREPO {
    Boolean actualizar(IntegranteSemillero nuevosDatosIntegrante);
}
