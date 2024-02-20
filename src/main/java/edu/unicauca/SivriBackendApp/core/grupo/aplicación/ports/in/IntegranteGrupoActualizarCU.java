package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;

public interface IntegranteGrupoActualizarCU {
    Respuesta<Boolean> actualizar(IntegranteGrupo nuevosDatos);
}
