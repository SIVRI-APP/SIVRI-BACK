package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "compromisoproyecto")
public class Compromisoproyecto {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "compromisoId")
    private Integer compromisoId;

    @Column(name = "proyectoId")
    private Integer proyectoId;

    @Column(name = "responsableId")
    private Integer responsableId;

    @Column(name = "estado")
    private String estado;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompromisoId() {
        return this.compromisoId;
    }

    public void setCompromisoId(Integer compromisoId) {
        this.compromisoId = compromisoId;
    }

    public Integer getProyectoId() {
        return this.proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }

    public Integer getResponsableId() {
        return this.responsableId;
    }

    public void setResponsableId(Integer responsableId) {
        this.responsableId = responsableId;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
