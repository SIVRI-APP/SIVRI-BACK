package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface GrupoDisciplinaEliminarCU {
    Respuesta<Boolean> eliminacionGrupoDisciplinaFisico(long id);
}
