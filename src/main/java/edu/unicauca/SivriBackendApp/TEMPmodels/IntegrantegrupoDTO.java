package edu.unicauca.SivriBackendApp.TEMPmodels;
import java.time.LocalDate;
public class IntegrantegrupoDTO {
    private Integer idIntegranteGrupo;
    private Integer grupoId;
    private String usuarioNumeroDocumento;
    private String estadoIntegranteGrupo;
    private LocalDate fechaInixio;
    private LocalDate fechaFin;
    private Integer rolGrupoId;

    public Integer getIdIntegranteGrupo() {
        return this.idIntegranteGrupo;
    }

    public void setIdIntegranteGrupo(Integer idIntegranteGrupo) {
        this.idIntegranteGrupo = idIntegranteGrupo;
    }

    public Integer getGrupoId() {
        return this.grupoId;
    }

    public void setGrupoId(Integer grupoId) {
        this.grupoId = grupoId;
    }

    public String getUsuarioNumeroDocumento() {
        return this.usuarioNumeroDocumento;
    }

    public void setUsuarioNumeroDocumento(String usuarioNumeroDocumento) {
        this.usuarioNumeroDocumento = usuarioNumeroDocumento;
    }

    public String getEstadoIntegranteGrupo() {
        return this.estadoIntegranteGrupo;
    }

    public void setEstadoIntegranteGrupo(String estadoIntegranteGrupo) {
        this.estadoIntegranteGrupo = estadoIntegranteGrupo;
    }

    public LocalDate getFechaInixio() {
        return this.fechaInixio;
    }

    public void setFechaInixio(LocalDate fechaInixio) {
        this.fechaInixio = fechaInixio;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getRolGrupoId() {
        return this.rolGrupoId;
    }

    public void setRolGrupoId(Integer rolGrupoId) {
        this.rolGrupoId = rolGrupoId;
    }
}
