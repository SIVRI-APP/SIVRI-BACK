package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "integrantegrupo")
public class Integrantegrupo {
    @Id
    @Column(name = "idIntegranteGrupo")
    private Integer idIntegranteGrupo;

    @Column(name = "grupoId")
    private Integer grupoId;

    @Column(name = "usuarioNumeroDocumento")
    private String usuarioNumeroDocumento;

    @Column(name = "estadoIntegranteGrupo")
    private String estadoIntegranteGrupo;

    @Column(name = "fechaInixio")
    private LocalDate fechaInixio;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @Column(name = "rolGrupo_id")
    private Integer rolGrupoId;

    public Integer getIdIntegranteGrupo() {
        return this.idIntegranteGrupo;
    }

    public void setIdIntegranteGrupo(Integer idIntegranteGrupo) {
        this.idIntegranteGrupo = idIntegranteGrupo;
    }

    public Integer getGrupoId() {
        return this.grupoId;
    }

    public void setGrupoId(Integer grupoId) {
        this.grupoId = grupoId;
    }

    public String getUsuarioNumeroDocumento() {
        return this.usuarioNumeroDocumento;
    }

    public void setUsuarioNumeroDocumento(String usuarioNumeroDocumento) {
        this.usuarioNumeroDocumento = usuarioNumeroDocumento;
    }

    public String getEstadoIntegranteGrupo() {
        return this.estadoIntegranteGrupo;
    }

    public void setEstadoIntegranteGrupo(String estadoIntegranteGrupo) {
        this.estadoIntegranteGrupo = estadoIntegranteGrupo;
    }

    public LocalDate getFechaInixio() {
        return this.fechaInixio;
    }

    public void setFechaInixio(LocalDate fechaInixio) {
        this.fechaInixio = fechaInixio;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getRolGrupoId() {
        return this.rolGrupoId;
    }

    public void setRolGrupoId(Integer rolGrupoId) {
        this.rolGrupoId = rolGrupoId;
    }
}
