package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoDisciplina;

import java.util.List;
import java.util.Optional;

public interface GrupoDisciplinaObtenerREPO {
    Boolean existePorId(long id);
    Optional<GrupoDisciplina> obtenerPorId(long id);
    List<GrupoDisciplina> obtenerListadoDisciplinasPorGrupoId(int idGrupo);

}
