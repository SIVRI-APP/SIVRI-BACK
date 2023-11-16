package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoDisciplina;

public interface GrupoDisciplinaActualizarREPO {
    Boolean actualizar(GrupoDisciplina nuevoDatos);
}
