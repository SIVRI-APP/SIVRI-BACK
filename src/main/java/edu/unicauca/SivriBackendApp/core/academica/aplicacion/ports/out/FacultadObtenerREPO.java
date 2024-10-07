package edu.unicauca.SivriBackendApp.core.academica.aplicacion.ports.out;


import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Facultad;

import java.util.List;
import java.util.Optional;

public interface FacultadObtenerREPO {
    Boolean existePorId(int id);
    Optional<Facultad> obtenerPorId(int id);

    List<Facultad> obtenerFacultades();
}
