package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "lineasdeinvestigacionproyecto")
public class Lineasdeinvestigacionproyecto {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "proyectoId")
    private Integer proyectoId;

    @Column(name = "nombre")
    private String nombre;

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

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
