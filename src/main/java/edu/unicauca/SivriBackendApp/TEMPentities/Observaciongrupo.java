package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "observaciongrupo")
public class Observaciongrupo {
    @Id
    @Column(name = "idObservacion")
    private Integer idObservacion;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha")
    private String fecha;

    @Id
    @Column(name = "grupo_idGrupo")
    private Integer grupoIdGrupo;

    @Id
    @Column(name = "usuarioNumeroDocumento")
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
