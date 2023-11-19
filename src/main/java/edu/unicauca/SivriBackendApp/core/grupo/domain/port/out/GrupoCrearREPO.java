package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;

public interface GrupoCrearREPO {
    Boolean crear(Grupo nuevoGrupo);
}
