package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "rolsemillero")
public class Rolsemillero {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "rolSemillero")
    private String rolSemillero;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolSemillero() {
        return this.rolSemillero;
    }

    public void setRolSemillero(String rolSemillero) {
        this.rolSemillero = rolSemillero;
    }
}
