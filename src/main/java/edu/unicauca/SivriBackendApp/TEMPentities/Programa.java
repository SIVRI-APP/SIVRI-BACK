package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "programa")
public class Programa {
    @Id
    @Column(name = "idPrograma")
    private Integer idPrograma;

    @Column(name = "nombrePrograma")
    private String nombrePrograma;

    @Id
    @Column(name = "departamento_id")
    private Integer departamentoId;

    public Integer getIdPrograma() {
        return this.idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombrePrograma() {
        return this.nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public Integer getDepartamentoId() {
        return this.departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }
}
