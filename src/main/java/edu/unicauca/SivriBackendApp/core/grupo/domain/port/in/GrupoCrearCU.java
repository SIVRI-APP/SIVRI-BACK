package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;

public interface GrupoCrearCU {
    Respuesta<Boolean> crear(Grupo grupo);

}
