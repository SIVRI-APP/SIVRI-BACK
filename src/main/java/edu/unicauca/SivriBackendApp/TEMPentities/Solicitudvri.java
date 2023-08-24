package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "solicitudvri")
public class Solicitudvri {
    @Id
    @Column(name = "idSolicitud")
    private Integer idSolicitud;

    @Column(name = "tipoSolicitud")
    private String tipoSolicitud;

    @Column(name = "dependencia")
    private String dependencia;

    @Column(name = "solicitud")
    private String solicitud;

    @Column(name = "fechaSolicitud")
    private LocalDate fechaSolicitud;

    @Column(name = "estadoSolicitud")
    private String estadoSolicitud;

    @Column(name = "evidenciaUrl")
    private String evidenciaUrl;

    @Column(name = "respuestaSolicitud")
    private String respuestaSolicitud;

    @Id
    @Column(name = "usuarioSolicitanteNumeroDocumento")
    private String usuarioSolicitanteNumeroDocumento;

    @Id
    @Column(name = "usuarioContestaNumeroDocumento")
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
