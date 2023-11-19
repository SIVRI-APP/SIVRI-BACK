package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;

import java.util.List;

public interface IntegranteGrupoObtenerCU {

    Respuesta<IntegranteGrupo> obtenerIntegrantePorId(int id);

    Respuesta<List<IntegranteGrupo>> obtenerIntegrantesGrupo();


}
