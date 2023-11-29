package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface GrupoDisciplinaEliminarCU {
    Respuesta<Boolean> eliminacionGrupoDisciplinaFisico(long id);
}
