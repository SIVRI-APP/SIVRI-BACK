package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.ProgramaEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rol_pregrado")
@PrimaryKeyJoinColumn(name = "rolAcademicoId")
@Getter
@Setter
@NoArgsConstructor
public class RolPregradoEntity extends RolEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "programaId")
    private ProgramaEntity programa;

    public RolPregradoEntity(Long id, Boolean estado, @FutureOrPresent LocalDate fechaInicio, @FutureOrPresent LocalDate fechaFin, UsuarioEntity usuario, RolUsuarioEntity rolUsuario, ProgramaEntity programa) {
        super(id, estado, fechaInicio, fechaFin, usuario, rolUsuario);
        this.programa = programa;
    }

    public RolPregradoEntity(ProgramaEntity programa) {
        this.programa = programa;
    }
}
