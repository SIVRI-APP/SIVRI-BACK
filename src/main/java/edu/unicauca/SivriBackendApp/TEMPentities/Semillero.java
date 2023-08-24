package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "semillero")
public class Semillero {
    @Id
    @Column(name = "idSemillero")
    private Integer idSemillero;

    @Column(name = "sede")
    private String sede;

    @Column(name = "organismoDeInvestigacionId")
    private Integer organismoDeInvestigacionId;

    @Id
    @Column(name = "grupoId")
    private Integer grupoId;

    public Integer getIdSemillero() {
        return this.idSemillero;
    }

    public void setIdSemillero(Integer idSemillero) {
        this.idSemillero = idSemillero;
    }

    public String getSede() {
        return this.sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Integer getOrganismoDeInvestigacionId() {
        return this.organismoDeInvestigacionId;
    }

    public void setOrganismoDeInvestigacionId(Integer organismoDeInvestigacionId) {
        this.organismoDeInvestigacionId = organismoDeInvestigacionId;
    }

    public Integer getGrupoId() {
        return this.grupoId;
    }

    public void setGrupoId(Integer grupoId) {
        this.grupoId = grupoId;
    }
}
