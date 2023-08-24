package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "administrativo")
public class Administrativo {
    @Id
    @Column(name = "tipoUsuarioId")
    private Integer tipoUsuarioId;

    @Column(name = "credencialesId")
    private Integer credencialesId;

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
}
