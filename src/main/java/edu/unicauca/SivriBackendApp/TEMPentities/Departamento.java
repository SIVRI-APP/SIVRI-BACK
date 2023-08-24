package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombreDepartamento")
    private String nombreDepartamento;

    @Id
    @Column(name = "facultad_idFacultad")
    private Integer facultadIdFacultad;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return this.nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Integer getFacultadIdFacultad() {
        return this.facultadIdFacultad;
    }

    public void setFacultadIdFacultad(Integer facultadIdFacultad) {
        this.facultadIdFacultad = facultadIdFacultad;
    }
}
