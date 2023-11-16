package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Disciplina;

public interface DisciplinaObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<Disciplina> obtenerPorId(int id);
}
