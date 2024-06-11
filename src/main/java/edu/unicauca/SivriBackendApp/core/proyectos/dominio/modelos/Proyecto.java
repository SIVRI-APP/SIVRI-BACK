package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    private Set<LineaDeInvestigacionProyecto> lineasDeInvestigacion;

    private Set<IntegranteProyecto> integrantes;

    private Set<EnfoqueDiferencialListado> enfoquesDiferenciales;

    private Convocatoria convocatoria;

}
