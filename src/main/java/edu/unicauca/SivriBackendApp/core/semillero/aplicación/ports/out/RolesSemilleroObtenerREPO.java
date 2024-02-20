package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.RolSemillero;

import java.util.List;
import java.util.Optional;

public interface RolesSemilleroObtenerREPO {
    Boolean existePorId(int id);
    List<RolSemillero> obtenerRolesSemillero();

    Optional<RolSemillero> obtenerRolSemilleroPorId(int id);
}
