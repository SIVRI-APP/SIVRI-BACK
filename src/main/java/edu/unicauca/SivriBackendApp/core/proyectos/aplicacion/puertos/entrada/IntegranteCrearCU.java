package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;

public interface IntegranteCrearCU {

    void crear(Usuario usuario, Proyecto proyecto, RolProyecto rol);

}
