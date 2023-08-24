package edu.unicauca.SivriBackendApp.TEMPmodels;
import java.time.LocalDate;
public class RolfuncionarioDTO {
    private Integer id;
    private Integer rolAdministrativoId;
    private Integer administrativoTipoUsuarioId;
    private String estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRolAdministrativoId() {
        return this.rolAdministrativoId;
    }

    public void setRolAdministrativoId(Integer rolAdministrativoId) {
        this.rolAdministrativoId = rolAdministrativoId;
    }

    public Integer getAdministrativoTipoUsuarioId() {
        return this.administrativoTipoUsuarioId;
    }

    public void setAdministrativoTipoUsuarioId(Integer administrativoTipoUsuarioId) {
        this.administrativoTipoUsuarioId = administrativoTipoUsuarioId;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
}
