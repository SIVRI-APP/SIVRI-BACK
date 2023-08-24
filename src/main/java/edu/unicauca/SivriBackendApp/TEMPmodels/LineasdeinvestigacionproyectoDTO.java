package edu.unicauca.SivriBackendApp.TEMPmodels;

public class LineasdeinvestigacionproyectoDTO {
    private Integer id;
    private Integer proyectoId;
    private String nombre;

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

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
