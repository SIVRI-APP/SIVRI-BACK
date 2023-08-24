package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "subarea")
public class Subarea {
    @Id
    @Column(name = "idSubArea")
    private Integer idSubArea;

    @Column(name = "nombreSubArea")
    private String nombreSubArea;

    @Id
    @Column(name = "area_idArea")
    private Integer areaIdArea;

    public Integer getIdSubArea() {
        return this.idSubArea;
    }

    public void setIdSubArea(Integer idSubArea) {
        this.idSubArea = idSubArea;
    }

    public String getNombreSubArea() {
        return this.nombreSubArea;
    }

    public void setNombreSubArea(String nombreSubArea) {
        this.nombreSubArea = nombreSubArea;
    }

    public Integer getAreaIdArea() {
        return this.areaIdArea;
    }

    public void setAreaIdArea(Integer areaIdArea) {
        this.areaIdArea = areaIdArea;
    }
}
