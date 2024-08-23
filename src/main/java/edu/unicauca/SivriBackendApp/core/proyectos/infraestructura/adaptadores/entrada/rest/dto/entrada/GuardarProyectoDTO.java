package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class GuardarProyectoDTO {

    @Valid
    private InformacionGeneralDTO informacionGeneral;
    private ConvocatoriaDTO convocatoria;
    private List<IntegranteDTO> integrantes;
    private List<String> enfoquesDiferenciales;
    private List<String> lineasDeInvestigacion;

    @Data
    public static class InformacionGeneralDTO {
        private Long id;
        private String estado;
        private String nombre;
        @FutureOrPresent(message = "Fecha de Fin debe ser una fecha en el presente o en el futuro")
        private LocalDate fechaFin;
        @FutureOrPresent(message = "Fecha de Inicio Debe ser una fecha en el presente o en el futuro")
        private LocalDate fechaInicio;
        private String objetivoGeneral;
        private String objetivosEspecificos;
        private String planteamiento;
        private String justificacion;
        private String enfoqueMetodologico;
        private String aspectosEticosLegales;
        private String impactosResultadosEsperados;
        private String confidencialidadDeInformacion;
        private String consideraciones;
        private Boolean eliminadoLogico;
        private String efectosAdversos;
    }

    @Data
    public static class ConvocatoriaDTO {
        private Long id;
        private String tipoFinanciacion;
        private String nombre;
        private List<ChecklistDTO> checklist;
    }

    @Data
    public static class ChecklistDTO {
        private Long id;
        private String etapaDocumento;
        private String responsableDocumento;
        private Integer cantidad;
        private Boolean obligatorio;
        private Boolean completado;
        private DocumentoConvocatoriaDTO documentoConvocatoria;
    }

    @Data
    public static class DocumentoConvocatoriaDTO {
        private Long id;
        private String nombre;
    }

    @Data
    public static class IntegranteDTO {
        private Long id;
        private UsuarioDTO usuario;
        private RolProyectoDTO rolProyecto;
    }

    @Data
    public static class UsuarioDTO {
        private Long id;
        private String apellido;
        private String nombre;
    }

    @Data
    public static class RolProyectoDTO {
        private Long id;
        private String nombre;
    }

}
