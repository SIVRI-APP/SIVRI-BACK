package edu.unicauca.SivriBackendApp.core.usuario.domain.model;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.ProgramaEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RolPregrado extends RolAcademico {

    private ProgramaEntity programa;

    public RolPregrado(Integer id, String nombre, List<RolUsuario> rolDeUsuarios, ProgramaEntity programa) {
        super(id, nombre, rolDeUsuarios);
        this.programa = programa;
    }
}
