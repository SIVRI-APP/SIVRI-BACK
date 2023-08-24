package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "organismodeinvestigacion")
public class Organismodeinvestigacion {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fechaCreacion")
    private LocalDate fechaCreacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "objetivo")
    private String objetivo;

    @Column(name = "mision")
    private String mision;

    @Column(name = "vision")
    private String vision;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getMision() {
        return this.mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return this.vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }
}
