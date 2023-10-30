package edu.unicauca.SivriBackendApp.core.academica.domain.port.out;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.Programa;

import java.util.List;
import java.util.Optional;

public interface ProgramaObtenerREPO {
    Boolean existePorId(int id);
    Optional<Programa> obtenerPorId(int id);
    List<Programa> listarProgramasPorSemillero(int idSemillero);
    List<Programa> obtenerProgramas();
}
