package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;

public interface SemilleroActualizarCU {

    Respuesta<Boolean> actualizarPorApoyo(Semillero nuevoSemillero);

    Respuesta<Boolean> actualizarEstadoSemillero(int idSemillero,Semillero nuevoEstadoSemillero);
    Respuesta<Boolean> actualizarPorMentor(Semillero nuevoSemillero);
}
