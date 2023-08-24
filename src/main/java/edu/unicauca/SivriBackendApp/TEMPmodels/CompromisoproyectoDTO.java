package edu.unicauca.SivriBackendApp.TEMPmodels;

public class CompromisoproyectoDTO {
    private Integer id;
    private Integer compromisoId;
    private Integer proyectoId;
    private Integer responsableId;
    private String estado;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompromisoId() {
        return this.compromisoId;
    }

    public void setCompromisoId(Integer compromisoId) {
        this.compromisoId = compromisoId;
    }

    public Integer getProyectoId() {
        return this.proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }

    public Integer getResponsableId() {
        return this.responsableId;
    }

    public void setResponsableId(Integer responsableId) {
        this.responsableId = responsableId;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
