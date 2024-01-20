package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;

import java.util.List;

public interface IntegranteGrupoObtenerCU {

    Respuesta<IntegranteGrupo> obtenerIntegrantePorId(int id);

    Respuesta<List<IntegranteGrupo>> obtenerIntegrantesGrupo();


}
