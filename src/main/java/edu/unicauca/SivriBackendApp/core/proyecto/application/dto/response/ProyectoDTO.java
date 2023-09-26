package edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.EnfoqueDiferencialProyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.IntegranteProyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.LineaDeInvestigacionProyecto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProyectoDTO {

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

//    @ManyToOne()
//    @JoinColumn(name = "convocatoriaId")
//    private ConvocatoriaEntity convocatoria;

    private List<IntegranteProyecto> integrantes;

    private List<EnfoqueDiferencialProyecto> enfoquesDiferenciales;
}
