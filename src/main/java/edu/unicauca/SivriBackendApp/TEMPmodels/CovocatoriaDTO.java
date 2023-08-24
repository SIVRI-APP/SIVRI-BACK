package edu.unicauca.SivriBackendApp.TEMPmodels;
import java.time.LocalDateTime;
public class CovocatoriaDTO {
    private Integer id;
    private Integer tipoFinanciacionId;
    private String nombre;
    private String objetivos;
    private String oferente;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String estado;
    private Byte recurrente;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipoFinanciacionId() {
        return this.tipoFinanciacionId;
    }

    public void setTipoFinanciacionId(Integer tipoFinanciacionId) {
        this.tipoFinanciacionId = tipoFinanciacionId;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObjetivos() {
        return this.objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getOferente() {
        return this.oferente;
    }

    public void setOferente(String oferente) {
        this.oferente = oferente;
    }

    public LocalDateTime getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Byte getRecurrente() {
        return this.recurrente;
    }

    public void setRecurrente(Byte recurrente) {
        this.recurrente = recurrente;
    }
}
