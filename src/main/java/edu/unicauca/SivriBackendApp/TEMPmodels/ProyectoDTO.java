package edu.unicauca.SivriBackendApp.TEMPmodels;
import java.time.LocalDate;
public class ProyectoDTO {
    private Integer id;
    private Integer covocatoriaId;
    private String nombre;
    private String estado;
    private LocalDate fechaInio;
    private LocalDate fechaFin;
    private String planteamiento;
    private String objetivoGeneral;
    private String objetivoEspecifico;
    private String justificacion;
    private String enfoqueMetodologico;
    private String aspectosEticosLegales;
    private String confidencialidadInformacion;
    private String efectosAdversos;
    private String impactosResultadosEsperados;
    private String consideraciones;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCovocatoriaId() {
        return this.covocatoriaId;
    }

    public void setCovocatoriaId(Integer covocatoriaId) {
        this.covocatoriaId = covocatoriaId;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaInio() {
        return this.fechaInio;
    }

    public void setFechaInio(LocalDate fechaInio) {
        this.fechaInio = fechaInio;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getPlanteamiento() {
        return this.planteamiento;
    }

    public void setPlanteamiento(String planteamiento) {
        this.planteamiento = planteamiento;
    }

    public String getObjetivoGeneral() {
        return this.objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public String getObjetivoEspecifico() {
        return this.objetivoEspecifico;
    }

    public void setObjetivoEspecifico(String objetivoEspecifico) {
        this.objetivoEspecifico = objetivoEspecifico;
    }

    public String getJustificacion() {
        return this.justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getEnfoqueMetodologico() {
        return this.enfoqueMetodologico;
    }

    public void setEnfoqueMetodologico(String enfoqueMetodologico) {
        this.enfoqueMetodologico = enfoqueMetodologico;
    }

    public String getAspectosEticosLegales() {
        return this.aspectosEticosLegales;
    }

    public void setAspectosEticosLegales(String aspectosEticosLegales) {
        this.aspectosEticosLegales = aspectosEticosLegales;
    }

    public String getConfidencialidadInformacion() {
        return this.confidencialidadInformacion;
    }

    public void setConfidencialidadInformacion(String confidencialidadInformacion) {
        this.confidencialidadInformacion = confidencialidadInformacion;
    }

    public String getEfectosAdversos() {
        return this.efectosAdversos;
    }

    public void setEfectosAdversos(String efectosAdversos) {
        this.efectosAdversos = efectosAdversos;
    }

    public String getImpactosResultadosEsperados() {
        return this.impactosResultadosEsperados;
    }

    public void setImpactosResultadosEsperados(String impactosResultadosEsperados) {
        this.impactosResultadosEsperados = impactosResultadosEsperados;
    }

    public String getConsideraciones() {
        return this.consideraciones;
    }

    public void setConsideraciones(String consideraciones) {
        this.consideraciones = consideraciones;
    }
}
