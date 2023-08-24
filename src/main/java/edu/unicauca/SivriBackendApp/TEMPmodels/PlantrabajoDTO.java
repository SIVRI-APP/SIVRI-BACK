package edu.unicauca.SivriBackendApp.TEMPmodels;

public class PlantrabajoDTO {
    private Integer idPlanTrabajo;
    private String nombrePlanTrabajo;
    private String estadoPlanTrabajo;
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
