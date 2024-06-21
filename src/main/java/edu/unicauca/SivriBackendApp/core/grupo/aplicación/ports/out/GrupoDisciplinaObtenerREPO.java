package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoDisciplina;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarDisciplinasPorGrupoId;

import java.util.List;
import java.util.Optional;

public interface GrupoDisciplinaObtenerREPO {
    Boolean existePorId(long id);
    Optional<GrupoDisciplina> obtenerPorId(long id);
    List<GrupoDisciplina> obtenerListadoDisciplinasPorGrupoId(int idGrupo);
    List<ListarDisciplinasPorGrupoId> obtenerDisciplinasxGrupoId(int idGrupo);

}
