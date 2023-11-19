package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;

import java.util.List;
import java.util.Optional;

public interface IntegranteGrupoObtenerREPO {

    Optional<IntegranteGrupo> obtenerIntegranteGrupoPorId(int id);

    List<IntegranteGrupo> obtenerIntegrantesGrupo();
}
