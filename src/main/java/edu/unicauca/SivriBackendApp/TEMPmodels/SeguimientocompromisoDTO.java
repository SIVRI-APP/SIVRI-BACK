package edu.unicauca.SivriBackendApp.TEMPmodels;
import java.time.LocalDate;
public class SeguimientocompromisoDTO {
    private Integer id;
    private Integer administrativoTipoUsuarioId;
    private Integer compromisoProyectoId;
    private String observacion;
    private LocalDate fechaObservacion;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdministrativoTipoUsuarioId() {
        return this.administrativoTipoUsuarioId;
    }

    public void setAdministrativoTipoUsuarioId(Integer administrativoTipoUsuarioId) {
        this.administrativoTipoUsuarioId = administrativoTipoUsuarioId;
    }

    public Integer getCompromisoProyectoId() {
        return this.compromisoProyectoId;
    }

    public void setCompromisoProyectoId(Integer compromisoProyectoId) {
        this.compromisoProyectoId = compromisoProyectoId;
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
