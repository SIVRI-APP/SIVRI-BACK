package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "compromisosemillero")
public class Compromisosemillero {
    @Id
    @Column(name = "idCompromiso")
    private Integer idCompromiso;

    @Column(name = "nombreCompromiso")
    private String nombreCompromiso;

    public Integer getIdCompromiso() {
        return this.idCompromiso;
    }

    public void setIdCompromiso(Integer idCompromiso) {
        this.idCompromiso = idCompromiso;
    }

    public String getNombreCompromiso() {
        return this.nombreCompromiso;
    }

    public void setNombreCompromiso(String nombreCompromiso) {
        this.nombreCompromiso = nombreCompromiso;
    }
}
