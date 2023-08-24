package edu.unicauca.SivriBackendApp.TEMPmodels;

public class DocumentosemilleroDTO {
    private Integer idDocumentoSemillero;
    private String avalDepartamento;
    private String otros;
    private String observacionDocumento;
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
