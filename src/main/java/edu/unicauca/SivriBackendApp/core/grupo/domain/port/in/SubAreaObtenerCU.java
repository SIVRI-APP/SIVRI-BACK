package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Disciplina;
import java.util.List;

public interface SubAreaObtenerCU {
    Respuesta<List<Disciplina>> obtenerDisciplinasPorIdSubArea(int id);
}
