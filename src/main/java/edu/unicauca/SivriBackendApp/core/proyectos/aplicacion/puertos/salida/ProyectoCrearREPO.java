package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;

public interface ProyectoCrearREPO {

    Proyecto crearProyecto(Proyecto proyecto);

    boolean formalizarProyecto(Proyecto proyecto);

    boolean guardarProyecto(ProyectoEntity proyecto);
}
