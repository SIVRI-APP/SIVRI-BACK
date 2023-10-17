package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.RolGrupo;

import java.util.List;
import java.util.Optional;

public interface RolesGrupoObtenerREPO {
    Boolean existePorId(int id);
    List<RolGrupo> obtenerRolesGrupo();

    Optional<RolGrupo> obtenerRolGrupoPorId(int id);
}
