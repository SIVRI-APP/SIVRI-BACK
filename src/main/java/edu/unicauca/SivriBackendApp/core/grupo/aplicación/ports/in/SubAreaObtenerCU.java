package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Disciplina;

import java.util.List;

public interface SubAreaObtenerCU {
    Respuesta<List<Disciplina>> obtenerDisciplinasPorIdSubArea(int id);
}
