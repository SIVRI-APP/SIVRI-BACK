package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "lineainvestigacion")
public class Lineainvestigacion {
    @Id
    @Column(name = "idLineaInvestigacion")
    private Integer idLineaInvestigacion;

    @Column(name = "nombreLinea")
    private String nombreLinea;

    @Id
    @Column(name = "semillero_idSemillero")
    private Integer semilleroIdSemillero;

    public Integer getIdLineaInvestigacion() {
        return this.idLineaInvestigacion;
    }

    public void setIdLineaInvestigacion(Integer idLineaInvestigacion) {
        this.idLineaInvestigacion = idLineaInvestigacion;
    }

    public String getNombreLinea() {
        return this.nombreLinea;
    }

    public void setNombreLinea(String nombreLinea) {
        this.nombreLinea = nombreLinea;
    }

    public Integer getSemilleroIdSemillero() {
        return this.semilleroIdSemillero;
    }

    public void setSemilleroIdSemillero(Integer semilleroIdSemillero) {
        this.semilleroIdSemillero = semilleroIdSemillero;
    }
}
