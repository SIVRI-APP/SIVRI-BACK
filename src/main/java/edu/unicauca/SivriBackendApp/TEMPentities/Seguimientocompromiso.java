package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "seguimientocompromiso")
public class Seguimientocompromiso {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "administrativoTipoUsuarioId")
    private Integer administrativoTipoUsuarioId;

    @Column(name = "compromisoProyectoId")
    private Integer compromisoProyectoId;

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

    public Integer getAdministrativoTipoUsuarioId() {
        return this.administrativoTipoUsuarioId;
    }

    public void setAdministrativoTipoUsuarioId(Integer administrativoTipoUsuarioId) {
        this.administrativoTipoUsuarioId = administrativoTipoUsuarioId;
    }

    public Integer getCompromisoProyectoId() {
        return this.compromisoProyectoId;
    }

    public void setCompromisoProyectoId(Integer compromisoProyectoId) {
        this.compromisoProyectoId = compromisoProyectoId;
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
