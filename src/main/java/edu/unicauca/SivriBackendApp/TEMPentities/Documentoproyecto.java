package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "documentoproyecto")
public class Documentoproyecto {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "proyectoId")
    private Integer proyectoId;

    @Column(name = "documentacionId")
    private Integer documentacionId;

    @Column(name = "estado")
    private String estado;

    @Column(name = "administrativo")
    private Byte administrativo;

    @Column(name = "obligatorio")
    private Byte obligatorio;

    @Column(name = "estapa")
    private String estapa;

    @Column(name = "cantidad")
    private Integer cantidad;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProyectoId() {
        return this.proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }

    public Integer getDocumentacionId() {
        return this.documentacionId;
    }

    public void setDocumentacionId(Integer documentacionId) {
        this.documentacionId = documentacionId;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Byte getAdministrativo() {
        return this.administrativo;
    }

    public void setAdministrativo(Byte administrativo) {
        this.administrativo = administrativo;
    }

    public Byte getObligatorio() {
        return this.obligatorio;
    }

    public void setObligatorio(Byte obligatorio) {
        this.obligatorio = obligatorio;
    }

    public String getEstapa() {
        return this.estapa;
    }

    public void setEstapa(String estapa) {
        this.estapa = estapa;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
