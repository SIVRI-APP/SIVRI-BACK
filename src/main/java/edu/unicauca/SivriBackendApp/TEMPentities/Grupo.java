package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "grupo")
public class Grupo {
    @Id
    @Column(name = "idGrupo")
    private Integer idGrupo;

    @Column(name = "organismoDeInvestigacionId")
    private Integer organismoDeInvestigacionId;

    @Column(name = "facultadId")
    private Integer facultadId;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "sitioWeb")
    private String sitioWeb;

    @Column(name = "escalafonColciencias")
    private String escalafonColciencias;

    @Column(name = "direccionGrupLac")
    private String direccionGrupLac;

    @Column(name = "codigoColciencias")
    private String codigoColciencias;

    @Column(name = "centroInvestigaciones")
    private String centroInvestigaciones;

    @Column(name = "realizaciones")
    private String realizaciones;

    @Column(name = "perspectivas")
    private String perspectivas;

    public Integer getIdGrupo() {
        return this.idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getOrganismoDeInvestigacionId() {
        return this.organismoDeInvestigacionId;
    }

    public void setOrganismoDeInvestigacionId(Integer organismoDeInvestigacionId) {
        this.organismoDeInvestigacionId = organismoDeInvestigacionId;
    }

    public Integer getFacultadId() {
        return this.facultadId;
    }

    public void setFacultadId(Integer facultadId) {
        this.facultadId = facultadId;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSitioWeb() {
        return this.sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getEscalafonColciencias() {
        return this.escalafonColciencias;
    }

    public void setEscalafonColciencias(String escalafonColciencias) {
        this.escalafonColciencias = escalafonColciencias;
    }

    public String getDireccionGrupLac() {
        return this.direccionGrupLac;
    }

    public void setDireccionGrupLac(String direccionGrupLac) {
        this.direccionGrupLac = direccionGrupLac;
    }

    public String getCodigoColciencias() {
        return this.codigoColciencias;
    }

    public void setCodigoColciencias(String codigoColciencias) {
        this.codigoColciencias = codigoColciencias;
    }

    public String getCentroInvestigaciones() {
        return this.centroInvestigaciones;
    }

    public void setCentroInvestigaciones(String centroInvestigaciones) {
        this.centroInvestigaciones = centroInvestigaciones;
    }

    public String getRealizaciones() {
        return this.realizaciones;
    }

    public void setRealizaciones(String realizaciones) {
        this.realizaciones = realizaciones;
    }

    public String getPerspectivas() {
        return this.perspectivas;
    }

    public void setPerspectivas(String perspectivas) {
        this.perspectivas = perspectivas;
    }
}
