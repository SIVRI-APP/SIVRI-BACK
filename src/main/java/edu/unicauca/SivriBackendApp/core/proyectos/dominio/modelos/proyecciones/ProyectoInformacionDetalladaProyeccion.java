package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;

import java.time.LocalDate;
import java.util.List;
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
    List<IntegranteProyectoProyeccion> getIntegrantes();
    Set<EnfoqueDiferencialListadoProjection> getEnfoquesDiferenciales();
    ConvocatoriaProjection getConvocatoria();

    interface LineaDeInvestigacionProyectoProjection {
        // Define los campos necesarios de LineaDeInvestigacionProyectoEntity
        Integer getId();
    }

    interface IntegranteProyectoProyeccion {
        // Define los campos necesarios de IntegranteProyectoEntity
        Integer getId();
        IntegranteUsuarioProyeccion getUsuario();
        IntegranteRolProyeccion getRolProyecto();

        interface IntegranteUsuarioProyeccion {
            Long getId();
            String getNombre();
            String getApellido();
        }
        interface IntegranteRolProyeccion {
            Integer getId();
            RolProyectoEnum getNombre();
        }
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
