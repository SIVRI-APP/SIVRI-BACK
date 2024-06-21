package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Disciplina;

public interface DisciplinaObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<Disciplina> obtenerPorId(int id);
}
