package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "covocatoria")
public class Covocatoria {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipoFinanciacionId")
    private Integer tipoFinanciacionId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "objetivos")
    private String objetivos;

    @Column(name = "oferente")
    private String oferente;

    @Column(name = "fechaInicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fechaFin")
    private LocalDateTime fechaFin;

    @Column(name = "estado")
    private String estado;

    @Column(name = "recurrente")
    private Byte recurrente;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipoFinanciacionId() {
        return this.tipoFinanciacionId;
    }

    public void setTipoFinanciacionId(Integer tipoFinanciacionId) {
        this.tipoFinanciacionId = tipoFinanciacionId;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObjetivos() {
        return this.objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getOferente() {
        return this.oferente;
    }

    public void setOferente(String oferente) {
        this.oferente = oferente;
    }

    public LocalDateTime getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Byte getRecurrente() {
        return this.recurrente;
    }

    public void setRecurrente(Byte recurrente) {
        this.recurrente = recurrente;
    }
}
