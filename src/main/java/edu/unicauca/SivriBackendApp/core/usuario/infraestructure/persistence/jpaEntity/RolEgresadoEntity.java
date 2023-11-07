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
public class RolEgresadoEntity extends RolEntity {
    public RolEgresadoEntity(Long id, Boolean estado, @FutureOrPresent LocalDate fechaInicio, @FutureOrPresent LocalDate fechaFin, UsuarioEntity usuario, RolUsuarioEntity rolUsuario) {
        super(id, estado, fechaInicio, fechaFin, usuario, rolUsuario);
    }

    public RolEgresadoEntity() {
    }
}
