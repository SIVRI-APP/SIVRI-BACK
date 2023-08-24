package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "observacionsemillero")
public class Observacionsemillero {
    @Id
    @Column(name = "idObservacion")
    private Integer idObservacion;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fechaObservacion")
    private LocalDate fechaObservacion;

    @Id
    @Column(name = "semilleroIdSemillero")
    private Integer semilleroIdSemillero;

    @Id
    @Column(name = "usuarioNumeroDocumento")
    private String usuarioNumeroDocumento;

    public Integer getIdObservacion() {
        return this.idObservacion;
    }

    public void setIdObservacion(Integer idObservacion) {
        this.idObservacion = idObservacion;
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

    public Integer getSemilleroIdSemillero() {
        return this.semilleroIdSemillero;
    }

    public void setSemilleroIdSemillero(Integer semilleroIdSemillero) {
        this.semilleroIdSemillero = semilleroIdSemillero;
    }

    public String getUsuarioNumeroDocumento() {
        return this.usuarioNumeroDocumento;
    }

    public void setUsuarioNumeroDocumento(String usuarioNumeroDocumento) {
        this.usuarioNumeroDocumento = usuarioNumeroDocumento;
    }
}
