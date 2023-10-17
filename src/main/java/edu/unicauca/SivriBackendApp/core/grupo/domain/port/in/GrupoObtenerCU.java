package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;

import java.util.List;

public interface GrupoObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<Grupo> obtenerGrupoPorId(int id);

    Respuesta<List<Grupo>> obtenerGrupos();

}
