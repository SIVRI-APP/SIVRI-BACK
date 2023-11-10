package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;

public interface GrupoDisciplinaEliminarCU {
    Respuesta<Boolean> eliminacionGrupoDisciplinaFisico(long id);
}
