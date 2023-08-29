package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.ProgramaEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "posgrado")
@PrimaryKeyJoinColumn(name = "rolAcademicoId")
@Getter
@Setter
@NoArgsConstructor
public class PosgradoEntity extends RolAcademicoEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "programaId")
    private ProgramaEntity programa;

    public PosgradoEntity(Integer id, String estado, @FutureOrPresent LocalDate fechaInicio, @FutureOrPresent LocalDate fechaFin, UsuarioEntity usuarioNumeroDocumento, ProgramaEntity programa) {
        super(id, estado, fechaInicio, fechaFin, usuarioNumeroDocumento);
        this.programa = programa;
    }
}
