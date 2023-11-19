package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoDisciplina;

import java.util.List;

public interface GrupoDisciplinaObtenerCU {
    Respuesta<Boolean> existePorId(long id);
    Respuesta<GrupoDisciplina> obtenerPorId(long id);
    Respuesta<List<GrupoDisciplina>> obtenerListadoDisciplinasPorGrupoId(int idGrupo);

}
