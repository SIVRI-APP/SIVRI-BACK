package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.RolGrupo;

import java.util.List;

public interface RolesGrupoObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<RolGrupo> obtenerRolGrupoPorId(int id);
    Respuesta<List<RolGrupo>> obtenerRolesGrupo();
}
