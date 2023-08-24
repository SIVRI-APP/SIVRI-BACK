package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "covocatoriaId")
    private Integer covocatoriaId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fechaInio")
    private LocalDate fechaInio;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @Column(name = "planteamiento")
    private String planteamiento;

    @Column(name = "objetivoGeneral")
    private String objetivoGeneral;

    @Column(name = "objetivoEspecifico")
    private String objetivoEspecifico;

    @Column(name = "justificacion")
    private String justificacion;

    @Column(name = "enfoqueMetodologico")
    private String enfoqueMetodologico;

    @Column(name = "aspectosEticosLegales")
    private String aspectosEticosLegales;

    @Column(name = "confidencialidadInformacion")
    private String confidencialidadInformacion;

    @Column(name = "efectosAdversos")
    private String efectosAdversos;

    @Column(name = "impactosResultadosEsperados")
    private String impactosResultadosEsperados;

    @Column(name = "consideraciones")
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
