package edu.unicauca.SivriBackendApp.TEMPmodels;
import java.time.LocalDate;
public class IntegrantesemilleroDTO {
    private Integer idIntegranteSemillero;
    private Integer semilleroId;
    private String usuarioNumeroDocumento;
    private String estadoIntegranteSemillero;
    private String semestreIntegranteSemillero;
    private LocalDate fechaIngresoIntegranteSemillero;
    private LocalDate fechaRetiroIntegranteSemillero;
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
