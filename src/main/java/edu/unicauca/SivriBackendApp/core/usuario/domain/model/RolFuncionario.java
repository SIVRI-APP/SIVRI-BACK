package edu.unicauca.SivriBackendApp.core.usuario.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RolFuncionario extends RolAcademico {

    public RolFuncionario(Integer id, String nombre, List<RolUsuario> rolDeUsuarios) {
        super(id, nombre, rolDeUsuarios);
    }
}
