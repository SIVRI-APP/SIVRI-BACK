package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "area")
public class Area {
    @Id
    @Column(name = "idArea")
    private Integer idArea;

    @Column(name = "nombreArea")
    private String nombreArea;

    public Integer getIdArea() {
        return this.idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getNombreArea() {
        return this.nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
}
