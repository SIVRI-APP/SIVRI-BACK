package edu.unicauca.SivriBackendApp.TEMPmodels;

public class SemilleroDTO {
    private Integer idSemillero;
    private String sede;
    private Integer organismoDeInvestigacionId;
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
