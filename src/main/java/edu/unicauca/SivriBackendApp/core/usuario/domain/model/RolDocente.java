package edu.unicauca.SivriBackendApp.core.usuario.domain.model;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.DepartamentoEntity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RolDocente extends RolAcademico {

    private String cvLac;

    private DepartamentoEntity departamento;

    public RolDocente(Integer id, String nombre, List<RolUsuario> rolDeUsuarios, String cvLac, DepartamentoEntity departamento) {
        super(id, nombre, rolDeUsuarios);
        this.cvLac = cvLac;
        this.departamento = departamento;
    }
}
