package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.ProgramaEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rol_posgrado")
@PrimaryKeyJoinColumn(name = "rolAcademicoId")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class RolPosgradoEntity extends RolEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "programaId")
    private ProgramaEntity programa;

    public RolPosgradoEntity(Long id, Boolean estado, @FutureOrPresent LocalDate fechaInicio, @FutureOrPresent LocalDate fechaFin, UsuarioEntity usuario, RolUsuarioEntity rolUsuario, ProgramaEntity programa) {
        super(id, estado, fechaInicio, fechaFin, usuario, rolUsuario);
        this.programa = programa;
    }

    public RolPosgradoEntity(ProgramaEntity programa) {
        this.programa = programa;
    }
}
