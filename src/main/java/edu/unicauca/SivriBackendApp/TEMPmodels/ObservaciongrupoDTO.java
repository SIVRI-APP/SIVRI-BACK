package edu.unicauca.SivriBackendApp.TEMPmodels;

public class ObservaciongrupoDTO {
    private Integer idObservacion;
    private String observacion;
    private String fecha;
    private Integer grupoIdGrupo;
    private String usuarioNumeroDocumento;

    public Integer getIdObservacion() {
        return this.idObservacion;
    }

    public void setIdObservacion(Integer idObservacion) {
        this.idObservacion = idObservacion;
    }

    public String getObservacion() {
        return this.observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getGrupoIdGrupo() {
        return this.grupoIdGrupo;
    }

    public void setGrupoIdGrupo(Integer grupoIdGrupo) {
        this.grupoIdGrupo = grupoIdGrupo;
    }

    public String getUsuarioNumeroDocumento() {
        return this.usuarioNumeroDocumento;
    }

    public void setUsuarioNumeroDocumento(String usuarioNumeroDocumento) {
        this.usuarioNumeroDocumento = usuarioNumeroDocumento;
    }
}
