package edu.unicauca.SivriBackendApp.core.proyecto.domain.model;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Proyecto {

    private Long id;

    private String nombre;

    private EstadoProyecto estado;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private String planteamiento;

    private String objetivoGeneral;

    private String objetivosEspecificos;

    private String justificacion;

    private String enfoqueMetodologico;

    private String aspectosEticosLegales;

    private String confidencialidadDeInformacion;

    private String efectosAdversos;

    private String impactosResultadosEsperados;

    private String consideraciones;

    private boolean eliminadoLogico;

    private List<LineaDeInvestigacionProyecto> lineasDeInvestigacion;

    private List<IntegranteProyecto> integrantes;

    private List<EnfoqueDiferencialProyecto> enfoquesDiferenciales;

    private Convocatoria convocatoria;
}
