package edu.unicauca.SivriBackendApp.TEMPmodels;
import java.time.LocalDate;
public class SolicitudvriDTO {
    private Integer idSolicitud;
    private String tipoSolicitud;
    private String dependencia;
    private String solicitud;
    private LocalDate fechaSolicitud;
    private String estadoSolicitud;
    private String evidenciaUrl;
    private String respuestaSolicitud;
    private String usuarioSolicitanteNumeroDocumento;
    private String usuarioContestaNumeroDocumento;

    public Integer getIdSolicitud() {
        return this.idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getTipoSolicitud() {
        return this.tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getDependencia() {
        return this.dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getSolicitud() {
        return this.solicitud;
    }

    public void setSolicitud(String solicitud) {
        this.solicitud = solicitud;
    }

    public LocalDate getFechaSolicitud() {
        return this.fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstadoSolicitud() {
        return this.estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getEvidenciaUrl() {
        return this.evidenciaUrl;
    }

    public void setEvidenciaUrl(String evidenciaUrl) {
        this.evidenciaUrl = evidenciaUrl;
    }

    public String getRespuestaSolicitud() {
        return this.respuestaSolicitud;
    }

    public void setRespuestaSolicitud(String respuestaSolicitud) {
        this.respuestaSolicitud = respuestaSolicitud;
    }

    public String getUsuarioSolicitanteNumeroDocumento() {
        return this.usuarioSolicitanteNumeroDocumento;
    }

    public void setUsuarioSolicitanteNumeroDocumento(String usuarioSolicitanteNumeroDocumento) {
        this.usuarioSolicitanteNumeroDocumento = usuarioSolicitanteNumeroDocumento;
    }

    public String getUsuarioContestaNumeroDocumento() {
        return this.usuarioContestaNumeroDocumento;
    }

    public void setUsuarioContestaNumeroDocumento(String usuarioContestaNumeroDocumento) {
        this.usuarioContestaNumeroDocumento = usuarioContestaNumeroDocumento;
    }
}
