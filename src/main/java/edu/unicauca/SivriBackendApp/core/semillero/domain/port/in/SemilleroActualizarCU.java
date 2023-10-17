package edu.unicauca.SivriBackendApp.core.semillero.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.request.SemilleroActualizarEstadoDTO;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import jakarta.validation.Valid;

public interface SemilleroActualizarCU {

    Respuesta<Boolean> actualizarPorApoyo(Semillero nuevoSemillero);


    Respuesta<Boolean> actualizarPorMentor(Semillero nuevoSemillero);
}
