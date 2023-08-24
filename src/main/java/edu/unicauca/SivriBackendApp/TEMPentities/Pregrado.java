package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "pregrado")
public class Pregrado {
    @Id
    @Column(name = "tipoUsuarioId")
    private Integer tipoUsuarioId;

    @Column(name = "programaId")
    private Integer programaId;

    public Integer getTipoUsuarioId() {
        return this.tipoUsuarioId;
    }

    public void setTipoUsuarioId(Integer tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public Integer getProgramaId() {
        return this.programaId;
    }

    public void setProgramaId(Integer programaId) {
        this.programaId = programaId;
    }
}
