package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;

public interface SemilleroCrearCU {


    Respuesta<Boolean> crear(Semillero semillero, long mentorId);
}
