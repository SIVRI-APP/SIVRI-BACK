package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "evidenciacompromiso")
public class Evidenciacompromiso {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "compromisoProyectoId")
    private Integer compromisoProyectoId;

    @Column(name = "rutaAlmacenamiento")
    private String rutaAlmacenamiento;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompromisoProyectoId() {
        return this.compromisoProyectoId;
    }

    public void setCompromisoProyectoId(Integer compromisoProyectoId) {
        this.compromisoProyectoId = compromisoProyectoId;
    }

    public String getRutaAlmacenamiento() {
        return this.rutaAlmacenamiento;
    }

    public void setRutaAlmacenamiento(String rutaAlmacenamiento) {
        this.rutaAlmacenamiento = rutaAlmacenamiento;
    }
}
