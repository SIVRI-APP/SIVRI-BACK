package edu.unicauca.SivriBackendApp.TEMPmodels;
import java.time.LocalDate;
public class SeguimientosdocumentoDTO {
    private Integer id;
    private Integer documentoProyectoId;
    private Integer administrativoTipoUsuarioId;
    private String observacion;
    private LocalDate fechaObservacion;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDocumentoProyectoId() {
        return this.documentoProyectoId;
    }

    public void setDocumentoProyectoId(Integer documentoProyectoId) {
        this.documentoProyectoId = documentoProyectoId;
    }

    public Integer getAdministrativoTipoUsuarioId() {
        return this.administrativoTipoUsuarioId;
    }

    public void setAdministrativoTipoUsuarioId(Integer administrativoTipoUsuarioId) {
        this.administrativoTipoUsuarioId = administrativoTipoUsuarioId;
    }

    public String getObservacion() {
        return this.observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LocalDate getFechaObservacion() {
        return this.fechaObservacion;
    }

    public void setFechaObservacion(LocalDate fechaObservacion) {
        this.fechaObservacion = fechaObservacion;
    }
}
