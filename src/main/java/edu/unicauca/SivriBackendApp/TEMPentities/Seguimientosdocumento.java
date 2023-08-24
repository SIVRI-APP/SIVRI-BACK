package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "seguimientosdocumento")
public class Seguimientosdocumento {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "documentoProyectoId")
    private Integer documentoProyectoId;

    @Column(name = "administrativoTipoUsuarioId")
    private Integer administrativoTipoUsuarioId;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fechaObservacion")
    private LocalDate fechaObservacion;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDocumentoProyectoId() {
        return this.documentoProyectoId;
    }

    public void setDocumentoProyectoId(Integer documentoProyectoId) {
        this.documentoProyectoId = documentoProyectoId;
    }

    public Integer getAdministrativoTipoUsuarioId() {
        return this.administrativoTipoUsuarioId;
    }

    public void setAdministrativoTipoUsuarioId(Integer administrativoTipoUsuarioId) {
        this.administrativoTipoUsuarioId = administrativoTipoUsuarioId;
    }

    public String getObservacion() {
        return this.observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LocalDate getFechaObservacion() {
        return this.fechaObservacion;
    }

    public void setFechaObservacion(LocalDate fechaObservacion) {
        this.fechaObservacion = fechaObservacion;
    }
}
