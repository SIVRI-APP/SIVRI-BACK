package edu.unicauca.SivriBackendApp.core.usuario.domain.model;

public enum TipoDocumento {
    CEDULA_CIUDADANIA("Cédula de Ciudadanía"),
    TARJETA_IDENTIDAD("Tarjeta de Identidad"),
    CEDULA_EXTRANJERIA("Cédula de Extranjería"),
    PASAPORTE("Pasaporte");

    private final String descripcion;

    TipoDocumento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
