package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;

public interface ObservacionSemilleroActualizarCU {
    Respuesta<Boolean> actualizarObservacionSemillero(int idObservacion, ObservacionSemillero nuevaObservacion);
}
