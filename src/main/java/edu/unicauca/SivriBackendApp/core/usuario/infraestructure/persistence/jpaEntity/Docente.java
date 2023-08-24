package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "docente")
public class Docente {
    @Id
    @Column(name = "tipoUsuarioId")
    private Integer tipoUsuarioId;

    @Column(name = "Credenciales_id")
    private Integer credencialesId;

    @Column(name = "departamentoId")
    private Integer departamentoId;

    @Column(name = "CvLAC")
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
