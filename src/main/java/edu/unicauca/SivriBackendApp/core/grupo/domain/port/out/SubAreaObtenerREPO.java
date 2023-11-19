package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;


import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Disciplina;

import java.util.List;

public interface SubAreaObtenerREPO {
    List<Disciplina> obtenerDisciplinaPorIdSubArea(int idSubArea);
}
