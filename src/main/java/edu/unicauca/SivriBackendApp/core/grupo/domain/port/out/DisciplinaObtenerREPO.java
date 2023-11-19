package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Disciplina;

import java.util.Optional;

public interface DisciplinaObtenerREPO {
    Boolean existePorId(int id);
    Optional<Disciplina> obtenerPorId(int id);
}
