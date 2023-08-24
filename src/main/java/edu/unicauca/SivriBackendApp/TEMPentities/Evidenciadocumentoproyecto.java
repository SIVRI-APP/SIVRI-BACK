package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "evidenciadocumentoproyecto")
public class Evidenciadocumentoproyecto {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "documentoProyectoId")
    private Integer documentoProyectoId;

    @Column(name = "rutaAlmacenamiento")
    private String rutaAlmacenamiento;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDocumentoProyectoId() {
        return this.documentoProyectoId;
    }

    public void setDocumentoProyectoId(Integer documentoProyectoId) {
        this.documentoProyectoId = documentoProyectoId;
    }

    public String getRutaAlmacenamiento() {
        return this.rutaAlmacenamiento;
    }

    public void setRutaAlmacenamiento(String rutaAlmacenamiento) {
        this.rutaAlmacenamiento = rutaAlmacenamiento;
    }
}
