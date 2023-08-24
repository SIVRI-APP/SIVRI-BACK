package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "integrantesemillero")
public class Integrantesemillero {
    @Id
    @Column(name = "idIntegranteSemillero")
    private Integer idIntegranteSemillero;

    @Column(name = "semilleroId")
    private Integer semilleroId;

    @Column(name = "usuarioNumeroDocumento")
    private String usuarioNumeroDocumento;

    @Column(name = "estadoIntegranteSemillero")
    private String estadoIntegranteSemillero;

    @Column(name = "semestreIntegranteSemillero")
    private String semestreIntegranteSemillero;

    @Column(name = "fechaIngresoIntegranteSemillero")
    private LocalDate fechaIngresoIntegranteSemillero;

    @Column(name = "fechaRetiroIntegranteSemillero")
    private LocalDate fechaRetiroIntegranteSemillero;

    @Column(name = "rolSemillero_id")
    private Integer rolSemilleroId;

    public Integer getIdIntegranteSemillero() {
        return this.idIntegranteSemillero;
    }

    public void setIdIntegranteSemillero(Integer idIntegranteSemillero) {
        this.idIntegranteSemillero = idIntegranteSemillero;
    }

    public Integer getSemilleroId() {
        return this.semilleroId;
    }

    public void setSemilleroId(Integer semilleroId) {
        this.semilleroId = semilleroId;
    }

    public String getUsuarioNumeroDocumento() {
        return this.usuarioNumeroDocumento;
    }

    public void setUsuarioNumeroDocumento(String usuarioNumeroDocumento) {
        this.usuarioNumeroDocumento = usuarioNumeroDocumento;
    }

    public String getEstadoIntegranteSemillero() {
        return this.estadoIntegranteSemillero;
    }

    public void setEstadoIntegranteSemillero(String estadoIntegranteSemillero) {
        this.estadoIntegranteSemillero = estadoIntegranteSemillero;
    }

    public String getSemestreIntegranteSemillero() {
        return this.semestreIntegranteSemillero;
    }

    public void setSemestreIntegranteSemillero(String semestreIntegranteSemillero) {
        this.semestreIntegranteSemillero = semestreIntegranteSemillero;
    }

    public LocalDate getFechaIngresoIntegranteSemillero() {
        return this.fechaIngresoIntegranteSemillero;
    }

    public void setFechaIngresoIntegranteSemillero(LocalDate fechaIngresoIntegranteSemillero) {
        this.fechaIngresoIntegranteSemillero = fechaIngresoIntegranteSemillero;
    }

    public LocalDate getFechaRetiroIntegranteSemillero() {
        return this.fechaRetiroIntegranteSemillero;
    }

    public void setFechaRetiroIntegranteSemillero(LocalDate fechaRetiroIntegranteSemillero) {
        this.fechaRetiroIntegranteSemillero = fechaRetiroIntegranteSemillero;
    }

    public Integer getRolSemilleroId() {
        return this.rolSemilleroId;
    }

    public void setRolSemilleroId(Integer rolSemilleroId) {
        this.rolSemilleroId = rolSemilleroId;
    }
}
