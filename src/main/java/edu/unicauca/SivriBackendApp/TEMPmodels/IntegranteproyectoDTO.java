package edu.unicauca.SivriBackendApp.TEMPmodels;
import java.time.LocalDate;
public class IntegranteproyectoDTO {
    private Integer id;
    private String usuarioNumeroDocumento;
    private Integer proyectoId;
    private Integer rolProyectoId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuarioNumeroDocumento() {
        return this.usuarioNumeroDocumento;
    }

    public void setUsuarioNumeroDocumento(String usuarioNumeroDocumento) {
        this.usuarioNumeroDocumento = usuarioNumeroDocumento;
    }

    public Integer getProyectoId() {
        return this.proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }

    public Integer getRolProyectoId() {
        return this.rolProyectoId;
    }

    public void setRolProyectoId(Integer rolProyectoId) {
        this.rolProyectoId = rolProyectoId;
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
