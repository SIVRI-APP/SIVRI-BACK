package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;

import java.util.List;
import java.util.Optional;

public interface IntegranteGrupoObtenerREPO {

    Optional<IntegranteGrupo> obtenerIntegranteGrupoPorId(int id);

    List<IntegranteGrupo> obtenerIntegrantesGrupo();
}
