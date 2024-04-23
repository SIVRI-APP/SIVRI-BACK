package edu.unicauca.SivriBackendApp.core.academica.aplicación.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Facultad;

public interface FacultadObtenerCU {

    Respuesta<Facultad> obtenerPorId(int id);
}
