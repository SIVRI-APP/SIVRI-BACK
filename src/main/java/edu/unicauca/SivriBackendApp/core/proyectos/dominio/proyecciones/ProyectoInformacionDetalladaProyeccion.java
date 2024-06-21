package edu.unicauca.SivriBackendApp.core.proyectos.dominio.proyecciones;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;

import java.time.LocalDate;
import java.util.Set;

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

    // Proyecciones para las relaciones
    Set<LineaDeInvestigacionProyectoProjection> getLineasDeInvestigacion();
    Set<IntegranteProyectoProjection> getIntegrantes();
    Set<EnfoqueDiferencialListadoProjection> getEnfoquesDiferenciales();
    ConvocatoriaProjection getConvocatoria();

    interface LineaDeInvestigacionProyectoProjection {
        // Define los campos necesarios de LineaDeInvestigacionProyectoEntity
        Integer getId();
    }

    interface IntegranteProyectoProjection {
        // Define los campos necesarios de IntegranteProyectoEntity
        Integer getId();
    }

    interface EnfoqueDiferencialListadoProjection {
        // Define los campos necesarios de EnfoqueDiferencialListadoEntity
        Integer getId();
    }

    interface ConvocatoriaProjection {
        // Define los campos necesarios de ConvocatoriaEntity
        Long getId();
        String getNombre();
        TipoFinanciacion getTipoFinanciacion();
    }
}
