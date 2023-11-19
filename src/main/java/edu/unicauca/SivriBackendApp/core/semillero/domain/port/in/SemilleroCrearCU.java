package edu.unicauca.SivriBackendApp.core.semillero.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;

public interface SemilleroCrearCU {


    Respuesta<Boolean> crear(Semillero semillero,String mentorId);
}
