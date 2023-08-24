package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "checklist")
public class Checklist {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipoFinanciacionId")
    private Integer tipoFinanciacionId;

    @Column(name = "documentacionId")
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
