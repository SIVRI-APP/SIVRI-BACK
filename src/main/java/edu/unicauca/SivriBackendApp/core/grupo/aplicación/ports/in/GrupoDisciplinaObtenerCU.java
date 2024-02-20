package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoDisciplina;

import java.util.List;

public interface GrupoDisciplinaObtenerCU {
    Respuesta<Boolean> existePorId(long id);
    Respuesta<GrupoDisciplina> obtenerPorId(long id);
    Respuesta<List<GrupoDisciplina>> obtenerListadoDisciplinasPorGrupoId(int idGrupo);

}
