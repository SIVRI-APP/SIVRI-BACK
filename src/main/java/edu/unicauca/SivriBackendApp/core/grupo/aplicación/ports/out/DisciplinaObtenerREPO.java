package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Disciplina;

import java.util.Optional;

public interface DisciplinaObtenerREPO {
    Boolean existePorId(int id);
    Optional<Disciplina> obtenerPorId(int id);
}
