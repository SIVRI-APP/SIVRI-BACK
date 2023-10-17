package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;

import java.util.List;
import java.util.Optional;

public interface GrupoObtenerREPO {
    Boolean existePorId(int id);
    Optional<Grupo> obtenerGrupoPorId(int id);

    List<Grupo> obtenerGrupos();

}
