package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "enfoquediferencialdeunproyecto")
public class Enfoquediferencialdeunproyecto {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "enfoqueDiferencialId")
    private Integer enfoqueDiferencialId;

    @Column(name = "proyectoId")
    private Integer proyectoId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnfoqueDiferencialId() {
        return this.enfoqueDiferencialId;
    }

    public void setEnfoqueDiferencialId(Integer enfoqueDiferencialId) {
        this.enfoqueDiferencialId = enfoqueDiferencialId;
    }

    public Integer getProyectoId() {
        return this.proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }
}
