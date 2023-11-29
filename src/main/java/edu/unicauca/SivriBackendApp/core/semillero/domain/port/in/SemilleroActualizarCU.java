package edu.unicauca.SivriBackendApp.core.semillero.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;

public interface SemilleroActualizarCU {

    Respuesta<Boolean> actualizarPorApoyo(Semillero nuevoSemillero);

    Respuesta<Boolean> actualizarEstadoSemillero(int idSemillero,Semillero nuevoEstadoSemillero);
    Respuesta<Boolean> actualizarPorMentor(Semillero nuevoSemillero);
}
