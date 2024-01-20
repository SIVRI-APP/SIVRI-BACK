package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.CompromisoSemillero;

import java.util.List;

public interface CompromisoSemilleroObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<CompromisoSemillero> obtenerPorId(int id);
    Respuesta<List<CompromisoSemillero>> obtenerListadoCompromisos();
}
