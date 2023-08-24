package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "posgrado")
public class Posgrado {
    @Id
    @Column(name = "tipoUsuarioId")
    private Integer tipoUsuarioId;

    @Column(name = "programaIdPrograma")
    private Integer programaIdPrograma;

    public Integer getTipoUsuarioId() {
        return this.tipoUsuarioId;
    }

    public void setTipoUsuarioId(Integer tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public Integer getProgramaIdPrograma() {
        return this.programaIdPrograma;
    }

    public void setProgramaIdPrograma(Integer programaIdPrograma) {
        this.programaIdPrograma = programaIdPrograma;
    }
}
