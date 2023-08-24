package edu.unicauca.SivriBackendApp.TEMPmodels;

public class DocenteDTO {
    private Integer tipoUsuarioId;
    private Integer credencialesId;
    private Integer departamentoId;
    private String cvLac;

    public Integer getTipoUsuarioId() {
        return this.tipoUsuarioId;
    }

    public void setTipoUsuarioId(Integer tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public Integer getCredencialesId() {
        return this.credencialesId;
    }

    public void setCredencialesId(Integer credencialesId) {
        this.credencialesId = credencialesId;
    }

    public Integer getDepartamentoId() {
        return this.departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getCvLac() {
        return this.cvLac;
    }

    public void setCvLac(String cvLac) {
        this.cvLac = cvLac;
    }
}
