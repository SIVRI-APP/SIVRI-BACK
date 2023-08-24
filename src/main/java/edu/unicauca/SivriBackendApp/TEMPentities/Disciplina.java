package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "disciplina")
public class Disciplina {
    @Id
    @Column(name = "idDisciplina")
    private Integer idDisciplina;

    @Column(name = "nombreDisciplina")
    private String nombreDisciplina;

    @Id
    @Column(name = "subArea_idSubArea")
    private Integer subAreaIdSubArea;

    public Integer getIdDisciplina() {
        return this.idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNombreDisciplina() {
        return this.nombreDisciplina;
    }

    public void setNombreDisciplina(String nombreDisciplina) {
        this.nombreDisciplina = nombreDisciplina;
    }

    public Integer getSubAreaIdSubArea() {
        return this.subAreaIdSubArea;
    }

    public void setSubAreaIdSubArea(Integer subAreaIdSubArea) {
        this.subAreaIdSubArea = subAreaIdSubArea;
    }
}
