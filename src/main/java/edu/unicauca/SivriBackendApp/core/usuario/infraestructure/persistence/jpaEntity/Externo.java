package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "externo")
public class Externo {
    @Id
    @Column(name = "tipoFinanciacionId")
    private Integer tipoFinanciacionId;

    public Integer getTipoFinanciacionId() {
        return this.tipoFinanciacionId;
    }

    public void setTipoFinanciacionId(Integer tipoFinanciacionId) {
        this.tipoFinanciacionId = tipoFinanciacionId;
    }
}
