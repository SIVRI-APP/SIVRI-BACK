package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "activdadplantrabajo")
public class Activdadplantrabajo {
    @Id
    @Column(name = "idActivdadPlan")
    private Integer idActivdadPlan;

    @Column(name = "objetivoActivdadPlan")
    private String objetivoActivdadPlan;

    @Column(name = "activdadPlan")
    private String activdadPlan;

    @Column(name = "fechaInicioActivdadPlan")
    private LocalDate fechaInicioActivdadPlan;

    @Column(name = "fechaFinActivdadPlan")
    private LocalDate fechaFinActivdadPlan;

    @Id
    @Column(name = "planTrabajo_idPlanTrabajo")
    private Integer planTrabajoIdPlanTrabajo;

    @Id
    @Column(name = "compromisoSemillero_idCompromisoSemillero")
    private Integer compromisoSemilleroIdCompromisoSemillero;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "documentoActividad_idDocumento")
    private Integer documentoActividadIdDocumento;

    public Integer getIdActivdadPlan() {
        return this.idActivdadPlan;
    }

    public void setIdActivdadPlan(Integer idActivdadPlan) {
        this.idActivdadPlan = idActivdadPlan;
    }

    public String getObjetivoActivdadPlan() {
        return this.objetivoActivdadPlan;
    }

    public void setObjetivoActivdadPlan(String objetivoActivdadPlan) {
        this.objetivoActivdadPlan = objetivoActivdadPlan;
    }

    public String getActivdadPlan() {
        return this.activdadPlan;
    }

    public void setActivdadPlan(String activdadPlan) {
        this.activdadPlan = activdadPlan;
    }

    public LocalDate getFechaInicioActivdadPlan() {
        return this.fechaInicioActivdadPlan;
    }

    public void setFechaInicioActivdadPlan(LocalDate fechaInicioActivdadPlan) {
        this.fechaInicioActivdadPlan = fechaInicioActivdadPlan;
    }

    public LocalDate getFechaFinActivdadPlan() {
        return this.fechaFinActivdadPlan;
    }

    public void setFechaFinActivdadPlan(LocalDate fechaFinActivdadPlan) {
        this.fechaFinActivdadPlan = fechaFinActivdadPlan;
    }

    public Integer getPlanTrabajoIdPlanTrabajo() {
        return this.planTrabajoIdPlanTrabajo;
    }

    public void setPlanTrabajoIdPlanTrabajo(Integer planTrabajoIdPlanTrabajo) {
        this.planTrabajoIdPlanTrabajo = planTrabajoIdPlanTrabajo;
    }

    public Integer getCompromisoSemilleroIdCompromisoSemillero() {
        return this.compromisoSemilleroIdCompromisoSemillero;
    }

    public void setCompromisoSemilleroIdCompromisoSemillero(Integer compromisoSemilleroIdCompromisoSemillero) {
        this.compromisoSemilleroIdCompromisoSemillero = compromisoSemilleroIdCompromisoSemillero;
    }

    public String getResponsable() {
        return this.responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Integer getDocumentoActividadIdDocumento() {
        return this.documentoActividadIdDocumento;
    }

    public void setDocumentoActividadIdDocumento(Integer documentoActividadIdDocumento) {
        this.documentoActividadIdDocumento = documentoActividadIdDocumento;
    }
}
