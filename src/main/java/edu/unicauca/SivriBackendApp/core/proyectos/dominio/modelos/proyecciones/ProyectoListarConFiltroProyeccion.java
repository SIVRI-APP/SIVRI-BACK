package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;

import java.time.LocalDate;

public interface ProyectoListarConFiltroProyeccion {
    Long getId();

    String getNombre();

    EstadoProyecto getEstado();

    TipoFinanciacion getTipoFinanciacion();

    LocalDate getFechaInicio();

    LocalDate getFechaFin();

    String getOrganismoNombre();

}
