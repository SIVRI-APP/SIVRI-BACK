package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "evidenciaactividad")
public class Evidenciaactividad {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "evidenxia")
    private String evidenxia;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvidenxia() {
        return this.evidenxia;
    }

    public void setEvidenxia(String evidenxia) {
        this.evidenxia = evidenxia;
    }
}
