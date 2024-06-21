package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.RolGrupo;

import java.util.List;
import java.util.Optional;

public interface RolesGrupoObtenerREPO {
    Boolean existePorId(int id);
    List<RolGrupo> obtenerRolesGrupo();

    Optional<RolGrupo> obtenerRolGrupoPorId(int id);
}
