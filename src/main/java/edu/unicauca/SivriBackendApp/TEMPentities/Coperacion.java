package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "coperacion")
public class Coperacion {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "proyectoId")
    private Integer proyectoId;

    @Column(name = "organismoInvestigacionId")
    private Integer organismoInvestigacionId;

    @Column(name = "principal")
    private Byte principal;

    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @Column(name = "estado")
    private String estado;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProyectoId() {
        return this.proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }

    public Integer getOrganismoInvestigacionId() {
        return this.organismoInvestigacionId;
    }

    public void setOrganismoInvestigacionId(Integer organismoInvestigacionId) {
        this.organismoInvestigacionId = organismoInvestigacionId;
    }

    public Byte getPrincipal() {
        return this.principal;
    }

    public void setPrincipal(Byte principal) {
        this.principal = principal;
    }

    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
