package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;


public interface ObservacionSemilleroCrearCU {
    Respuesta<Boolean> crear(Long funcionarioId, int semilleroId, ObservacionSemillero observacion);
}
