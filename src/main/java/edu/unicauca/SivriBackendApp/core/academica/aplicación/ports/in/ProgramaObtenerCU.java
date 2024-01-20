package edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.Programa;

import java.util.List;

public interface ProgramaObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<Programa> obtenerPorId(int id);
    Respuesta<List<Programa>> listarProgramasPorSemillero(int idSemillero);
    Respuesta<List<Programa>> obtenerProgramas();
}
