package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;

import java.util.Optional;

public interface ProyectoCrearCU {

    Respuesta<Boolean> crearProyecto(Proyecto proyecto);

    Respuesta<Boolean> asociarConvocatoria(long proyectoId, long convocatoriaId);
}
