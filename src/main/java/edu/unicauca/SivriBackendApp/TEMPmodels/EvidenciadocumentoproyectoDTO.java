package edu.unicauca.SivriBackendApp.TEMPmodels;

public class EvidenciadocumentoproyectoDTO {
    private Integer id;
    private Integer documentoProyectoId;
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
