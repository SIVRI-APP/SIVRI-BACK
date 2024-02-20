package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.RolGrupo;

import java.util.List;

public interface RolesGrupoObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<RolGrupo> obtenerRolGrupoPorId(int id);
    Respuesta<List<RolGrupo>> obtenerRolesGrupo();
}
