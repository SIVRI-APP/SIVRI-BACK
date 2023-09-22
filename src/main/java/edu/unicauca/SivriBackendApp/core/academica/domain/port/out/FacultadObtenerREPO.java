package edu.unicauca.SivriBackendApp.core.academica.domain.port.out;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.Facultad;

import java.util.List;
import java.util.Optional;

public interface FacultadObtenerREPO {
    Optional<Facultad> obtenerPorId(int id);

    List<Facultad> obtenerFacultades();
}
