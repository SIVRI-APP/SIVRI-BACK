package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;

public interface IntegranteGrupoActualizarREPO {

    Boolean actualizar(IntegranteGrupo nuevosDatos);
}