package edu.unicauca.SivriBackendApp.TEMPmodels;
import java.time.LocalDate;
public class OrganismodeinvestigacionDTO {
    private Integer id;
    private String nombre;
    private LocalDate fechaCreacion;
    private String estado;
    private String objetivo;
    private String mision;
    private String vision;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getMision() {
        return this.mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return this.vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }
}
