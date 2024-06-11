package edu.unicauca.SivriBackendApp.core.proyectos.dominio.proyecciones;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;

public interface ProyectoListarConFiltroProyeccion {
    Long getId();

    String getNombre();

    String getEstado();

    TipoFinanciacion getTipoFinanciacion();

}
