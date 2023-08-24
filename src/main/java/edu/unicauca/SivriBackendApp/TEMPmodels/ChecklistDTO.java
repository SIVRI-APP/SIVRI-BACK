package edu.unicauca.SivriBackendApp.TEMPmodels;

public class ChecklistDTO {
    private Integer id;
    private Integer tipoFinanciacionId;
    private Integer documentacionId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipoFinanciacionId() {
        return this.tipoFinanciacionId;
    }

    public void setTipoFinanciacionId(Integer tipoFinanciacionId) {
        this.tipoFinanciacionId = tipoFinanciacionId;
    }

    public Integer getDocumentacionId() {
        return this.documentacionId;
    }

    public void setDocumentacionId(Integer documentacionId) {
        this.documentacionId = documentacionId;
    }
}
