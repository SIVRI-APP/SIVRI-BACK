package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;

public interface GrupoActualizarCU {
    Respuesta<Boolean> actualizarPorApoyo(Grupo nuevosDatos);

    Respuesta<Boolean> actualizarPorDirector(Grupo nuevosDatos);

    Respuesta<Boolean> actualizarGrupoFormuladoPorDirector(Grupo datosGrupo);
    Respuesta<Boolean> actualizarGrupoActivoPorDirector(Grupo datosGrupo);

}
