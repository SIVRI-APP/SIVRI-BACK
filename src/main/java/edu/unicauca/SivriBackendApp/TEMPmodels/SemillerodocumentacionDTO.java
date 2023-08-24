package edu.unicauca.SivriBackendApp.TEMPmodels;
import java.time.LocalDate;
public class SemillerodocumentacionDTO {
    private Integer semilleroIdSemillero;
    private Integer documentoSemilleroIdDocumentoSemillero;
    private LocalDate fecha;

    public Integer getSemilleroIdSemillero() {
        return this.semilleroIdSemillero;
    }

    public void setSemilleroIdSemillero(Integer semilleroIdSemillero) {
        this.semilleroIdSemillero = semilleroIdSemillero;
    }

    public Integer getDocumentoSemilleroIdDocumentoSemillero() {
        return this.documentoSemilleroIdDocumentoSemillero;
    }

    public void setDocumentoSemilleroIdDocumentoSemillero(Integer documentoSemilleroIdDocumentoSemillero) {
        this.documentoSemilleroIdDocumentoSemillero = documentoSemilleroIdDocumentoSemillero;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
