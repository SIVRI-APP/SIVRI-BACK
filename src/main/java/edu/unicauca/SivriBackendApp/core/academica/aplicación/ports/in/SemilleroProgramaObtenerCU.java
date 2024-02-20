package edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.SemilleroPrograma;

import java.util.List;

public interface SemilleroProgramaObtenerCU {
    Respuesta<Boolean> existePorId(long id);
    Respuesta<SemilleroPrograma> obtenerPorId(long id);
    Respuesta<List<SemilleroPrograma>> obtenerListadoProgramasPorSemilleroId(int idSemillero);

}
