package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;

public interface ProyectoCrearCU {

    Respuesta<Boolean> crearProyecto(Proyecto proyecto);
}
