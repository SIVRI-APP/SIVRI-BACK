package edu.unicauca.SivriBackendApp.TEMPmodels;

public class DepartamentoDTO {
    private Integer id;
    private String nombreDepartamento;
    private Integer facultadIdFacultad;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return this.nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Integer getFacultadIdFacultad() {
        return this.facultadIdFacultad;
    }

    public void setFacultadIdFacultad(Integer facultadIdFacultad) {
        this.facultadIdFacultad = facultadIdFacultad;
    }
}
