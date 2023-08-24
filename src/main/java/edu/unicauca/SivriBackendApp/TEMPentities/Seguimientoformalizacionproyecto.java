package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "seguimientoformalizacionproyecto")
public class Seguimientoformalizacionproyecto {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "administrativoTipoUsuarioId")
    private Integer administrativoTipoUsuarioId;

    @Column(name = "proyectoId")
    private Integer proyectoId;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fechaObservacion")
    private LocalDate fechaObservacion;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdministrativoTipoUsuarioId() {
        return this.administrativoTipoUsuarioId;
    }

    public void setAdministrativoTipoUsuarioId(Integer administrativoTipoUsuarioId) {
        this.administrativoTipoUsuarioId = administrativoTipoUsuarioId;
    }

    public Integer getProyectoId() {
        return this.proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getObservacion() {
        return this.observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaObservacion() {
        return this.fechaObservacion;
    }

    public void setFechaObservacion(LocalDate fechaObservacion) {
        this.fechaObservacion = fechaObservacion;
    }
}
