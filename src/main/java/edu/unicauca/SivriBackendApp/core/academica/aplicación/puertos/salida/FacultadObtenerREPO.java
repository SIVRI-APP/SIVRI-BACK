package edu.unicauca.SivriBackendApp.core.academica.aplicación.puertos.salida;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Facultad;

import java.util.Optional;


public interface FacultadObtenerREPO {

    Optional<Facultad> obtenerPorId (int id);
}
