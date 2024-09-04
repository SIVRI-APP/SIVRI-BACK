package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;

import java.time.LocalDate;

public interface ProyectoInformacionDetalladaProyeccion {

    Long getId();
    String getNombre();
    EstadoProyecto getEstado();
    LocalDate getFechaInicio();
    LocalDate getFechaFin();
    String getPlanteamiento();
    String getObjetivoGeneral();
    String getObjetivosEspecificos();
    String getJustificacion();
    String getEnfoqueMetodologico();
    String getAspectosEticosLegales();
    String getConfidencialidadDeInformacion();
    String getEfectosAdversos();
    String getImpactosResultadosEsperados();
    String getConsideraciones();
    boolean isEliminadoLogico();

}
