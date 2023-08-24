package edu.unicauca.SivriBackendApp.TEMPmodels;

public class ProgramaDTO {
    private Integer idPrograma;
    private String nombrePrograma;
    private Integer departamentoId;

    public Integer getIdPrograma() {
        return this.idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombrePrograma() {
        return this.nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public Integer getDepartamentoId() {
        return this.departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }
}
