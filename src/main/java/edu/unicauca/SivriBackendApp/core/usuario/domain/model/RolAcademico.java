package edu.unicauca.SivriBackendApp.core.usuario.domain.model;

import lombok.*;

import java.util.List;

@Data
public abstract class RolAcademico {

    private Integer id;

    private String nombre;

    private List<RolUsuario> rolDeUsuarios;

    public RolAcademico(Integer id, String nombre, List<RolUsuario> rolDeUsuarios) {
        this.id = id;
        this.nombre = nombre;
        this.rolDeUsuarios = rolDeUsuarios;
    }
}
