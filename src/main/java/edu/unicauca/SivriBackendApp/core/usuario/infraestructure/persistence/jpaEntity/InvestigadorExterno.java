package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "investigadorexterno")
public class InvestigadorExterno {
    @Id
    @Column(name = "tipoUsuarioId")
    private Integer tipoUsuarioId;

    public Integer getTipoUsuarioId() {
        return this.tipoUsuarioId;
    }

    public void setTipoUsuarioId(Integer tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }
}
