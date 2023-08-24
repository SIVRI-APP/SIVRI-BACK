package edu.unicauca.SivriBackendApp.TEMPmodels;
import java.time.LocalDate;
public class ActivdadplantrabajoDTO {
    private Integer idActivdadPlan;
    private String objetivoActivdadPlan;
    private String activdadPlan;
    private LocalDate fechaInicioActivdadPlan;
    private LocalDate fechaFinActivdadPlan;
    private Integer planTrabajoIdPlanTrabajo;
    private Integer compromisoSemilleroIdCompromisoSemillero;
    private String responsable;
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
