package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.RolSemillero;

import java.util.List;

public interface RolesSemilleroObtenerCU {

    Respuesta<Boolean> existePorId(int id);
    Respuesta<RolSemillero> obtenerRolSemilleroPorId(int id);
    Respuesta<List<RolSemillero>> obtenerRolesSemillero();
}
