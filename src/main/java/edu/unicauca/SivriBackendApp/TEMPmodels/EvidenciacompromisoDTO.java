package edu.unicauca.SivriBackendApp.TEMPmodels;

public class EvidenciacompromisoDTO {
    private Integer id;
    private Integer compromisoProyectoId;
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
