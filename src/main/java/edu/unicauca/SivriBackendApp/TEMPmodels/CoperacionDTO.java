package edu.unicauca.SivriBackendApp.TEMPmodels;
import java.time.LocalDate;
public class CoperacionDTO {
    private Integer id;
    private Integer proyectoId;
    private Integer organismoInvestigacionId;
    private Byte principal;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProyectoId() {
        return this.proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }

    public Integer getOrganismoInvestigacionId() {
        return this.organismoInvestigacionId;
    }

    public void setOrganismoInvestigacionId(Integer organismoInvestigacionId) {
        this.organismoInvestigacionId = organismoInvestigacionId;
    }

    public Byte getPrincipal() {
        return this.principal;
    }

    public void setPrincipal(Byte principal) {
        this.principal = principal;
    }

    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
