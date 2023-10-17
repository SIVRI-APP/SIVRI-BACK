package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;

public interface GrupoActualizarREPO {

    Boolean actualizarPorApoyo(Grupo nuevosDatos);

    Boolean actualizarPorDirector(Grupo nuevosDatos);

    Boolean actualizarGrupoFormuladoPorDirector(Grupo datosGrupo);

    Boolean actualizarGrupoActivoPorDirector(Grupo datosGrupo);

}
