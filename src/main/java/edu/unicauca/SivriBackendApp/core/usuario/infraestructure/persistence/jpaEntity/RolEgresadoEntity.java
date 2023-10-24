package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rol_egresado")
@PrimaryKeyJoinColumn(name = "rolAcademicoId")
@Getter
@Setter
@NoArgsConstructor
public class RolEgresadoEntity extends RolAcademicoEntity {
    public RolEgresadoEntity(Integer id, String nombre, List<RolUsuarioEntity> rolDeUsuarios) {
        super(id, nombre, rolDeUsuarios);
    }
}
