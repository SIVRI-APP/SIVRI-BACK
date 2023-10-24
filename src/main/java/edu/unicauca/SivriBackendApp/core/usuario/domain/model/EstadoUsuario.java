package edu.unicauca.SivriBackendApp.core.usuario.domain.model;

public enum EstadoUsuario {
    ACTIVO("Activo"),
    REVISION_VRI("Revision VRI"),
    DENEGADO_OBSERVACIONES("Denegado con observaciones"),
    PENDIENTE_ACEPTACION("Pendiente aceptacion por parte del Usuario");

    private final String descripcion;

    EstadoUsuario(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
