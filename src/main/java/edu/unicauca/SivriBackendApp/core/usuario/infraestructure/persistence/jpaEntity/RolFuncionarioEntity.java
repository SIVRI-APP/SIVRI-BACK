package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rol_funcionario")
@PrimaryKeyJoinColumn(name = "rolAcademicoId")
@Getter
@Setter
@NoArgsConstructor
public class RolFuncionarioEntity extends RolAcademicoEntity {

    public RolFuncionarioEntity(Integer id, String nombre, List<RolUsuarioEntity> rolDeUsuarios) {
        super(id, nombre, rolDeUsuarios);
    }
}
