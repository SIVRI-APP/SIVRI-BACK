package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "facultad")
public class Facultad {
    @Id
    @Column(name = "idFacultad")
    private Integer idFacultad;

    @Column(name = "nombreFacultad")
    private String nombreFacultad;

    public Integer getIdFacultad() {
        return this.idFacultad;
    }

    public void setIdFacultad(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombreFacultad() {
        return this.nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }
}
