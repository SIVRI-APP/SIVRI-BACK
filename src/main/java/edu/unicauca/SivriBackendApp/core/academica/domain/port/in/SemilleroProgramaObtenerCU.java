package edu.unicauca.SivriBackendApp.core.academica.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.SemilleroPrograma;

import java.util.List;

public interface SemilleroProgramaObtenerCU {
    Respuesta<Boolean> existePorId(long id);
    Respuesta<SemilleroPrograma> obtenerPorId(long id);
    Respuesta<List<SemilleroPrograma>> obtenerListadoProgramasPorSemilleroId(int idSemillero);

}
