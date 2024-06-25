package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada.CrearProyectoDTO;


public interface ProyectoCrearCU {

    Respuesta<Boolean> crearProyecto(CrearProyectoDTO proyecto);

    Respuesta<Boolean> asociarConvocatoria(long proyectoId, long convocatoriaId);
}
