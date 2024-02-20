package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Disciplina;

import java.util.List;

public interface SubAreaObtenerREPO {
    List<Disciplina> obtenerDisciplinaPorIdSubArea(int idSubArea);
}
