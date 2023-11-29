package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;

public interface GrupoCrearCU {
    //TODO falta capturar el id del director y agregarlo en integrantes grupo
    Respuesta<Boolean> crear(Grupo grupo);

}
