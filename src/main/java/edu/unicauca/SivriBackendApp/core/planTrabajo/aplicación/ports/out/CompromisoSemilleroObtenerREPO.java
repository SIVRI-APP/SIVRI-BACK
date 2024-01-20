package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.CompromisoSemillero;

import java.util.List;
import java.util.Optional;

public interface CompromisoSemilleroObtenerREPO {
    Boolean existePorId(int id);
    Optional<CompromisoSemillero> obtenerPorId(int id);
    List<CompromisoSemillero> obtenerListadoCompromisos();
}
