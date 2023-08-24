package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "semillerodocumentacion")
public class Semillerodocumentacion {
    @Id
    @Column(name = "semillero_idSemillero")
    private Integer semilleroIdSemillero;

    @Id
    @Column(name = "documentoSemillero_idDocumentoSemillero")
    private Integer documentoSemilleroIdDocumentoSemillero;

    @Column(name = "fecha")
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
