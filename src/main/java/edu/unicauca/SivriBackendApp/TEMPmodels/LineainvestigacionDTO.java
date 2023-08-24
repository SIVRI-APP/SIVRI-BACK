package edu.unicauca.SivriBackendApp.TEMPmodels;

public class LineainvestigacionDTO {
    private Integer idLineaInvestigacion;
    private String nombreLinea;
    private Integer semilleroIdSemillero;

    public Integer getIdLineaInvestigacion() {
        return this.idLineaInvestigacion;
    }

    public void setIdLineaInvestigacion(Integer idLineaInvestigacion) {
        this.idLineaInvestigacion = idLineaInvestigacion;
    }

    public String getNombreLinea() {
        return this.nombreLinea;
    }

    public void setNombreLinea(String nombreLinea) {
        this.nombreLinea = nombreLinea;
    }

    public Integer getSemilleroIdSemillero() {
        return this.semilleroIdSemillero;
    }

    public void setSemilleroIdSemillero(Integer semilleroIdSemillero) {
        this.semilleroIdSemillero = semilleroIdSemillero;
    }
}
