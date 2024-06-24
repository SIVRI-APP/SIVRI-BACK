package edu.unicauca.SivriBackendApp.core.academica.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.Programa;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarProgramas;

import java.util.List;

public interface ProgramaObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<Programa> obtenerPorId(int id);
    Respuesta<List<Programa>> listarProgramasPorSemillero(int idSemillero);
    Respuesta<List<Programa>> obtenerProgramas();
    Respuesta<List<ListarProgramas>> obtenerProgramasxdepatamento(Integer semilleroId);
}
