package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "documentosemillero")
public class Documentosemillero {
    @Id
    @Column(name = "idDocumentoSemillero")
    private Integer idDocumentoSemillero;

    @Column(name = "avalDepartamento")
    private String avalDepartamento;

    @Column(name = "otros")
    private String otros;

    @Column(name = "observacionDocumento")
    private String observacionDocumento;

    @Column(name = "estadoDocumento")
    private String estadoDocumento;

    public Integer getIdDocumentoSemillero() {
        return this.idDocumentoSemillero;
    }

    public void setIdDocumentoSemillero(Integer idDocumentoSemillero) {
        this.idDocumentoSemillero = idDocumentoSemillero;
    }

    public String getAvalDepartamento() {
        return this.avalDepartamento;
    }

    public void setAvalDepartamento(String avalDepartamento) {
        this.avalDepartamento = avalDepartamento;
    }

    public String getOtros() {
        return this.otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public String getObservacionDocumento() {
        return this.observacionDocumento;
    }

    public void setObservacionDocumento(String observacionDocumento) {
        this.observacionDocumento = observacionDocumento;
    }

    public String getEstadoDocumento() {
        return this.estadoDocumento;
    }

    public void setEstadoDocumento(String estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }
}
