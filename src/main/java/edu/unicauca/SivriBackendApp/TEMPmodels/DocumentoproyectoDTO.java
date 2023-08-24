package edu.unicauca.SivriBackendApp.TEMPmodels;

public class DocumentoproyectoDTO {
    private Integer id;
    private Integer proyectoId;
    private Integer documentacionId;
    private String estado;
    private Byte administrativo;
    private Byte obligatorio;
    private String estapa;
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
