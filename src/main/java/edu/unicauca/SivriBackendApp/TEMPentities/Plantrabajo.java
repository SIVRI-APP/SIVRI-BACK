package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "plantrabajo")
public class Plantrabajo {
    @Id
    @Column(name = "idPlanTrabajo")
    private Integer idPlanTrabajo;

    @Column(name = "nombrePlanTrabajo")
    private String nombrePlanTrabajo;

    @Column(name = "estadoPlanTrabajo")
    private String estadoPlanTrabajo;

    @Id
    @Column(name = "semillero_idSemillero")
    private Integer semilleroIdSemillero;

    public Integer getIdPlanTrabajo() {
        return this.idPlanTrabajo;
    }

    public void setIdPlanTrabajo(Integer idPlanTrabajo) {
        this.idPlanTrabajo = idPlanTrabajo;
    }

    public String getNombrePlanTrabajo() {
        return this.nombrePlanTrabajo;
    }

    public void setNombrePlanTrabajo(String nombrePlanTrabajo) {
        this.nombrePlanTrabajo = nombrePlanTrabajo;
    }

    public String getEstadoPlanTrabajo() {
        return this.estadoPlanTrabajo;
    }

    public void setEstadoPlanTrabajo(String estadoPlanTrabajo) {
        this.estadoPlanTrabajo = estadoPlanTrabajo;
    }

    public Integer getSemilleroIdSemillero() {
        return this.semilleroIdSemillero;
    }

    public void setSemilleroIdSemillero(Integer semilleroIdSemillero) {
        this.semilleroIdSemillero = semilleroIdSemillero;
    }
}
