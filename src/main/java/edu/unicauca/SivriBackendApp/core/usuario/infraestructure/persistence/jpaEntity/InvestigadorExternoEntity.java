package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "investigadorexterno")
@PrimaryKeyJoinColumn(name = "rolAcademicoId")
@Getter
@Setter
@NoArgsConstructor
public class InvestigadorExternoEntity extends RolAcademicoEntity{
    public InvestigadorExternoEntity(Integer id, String estado, @FutureOrPresent LocalDate fechaInicio, @FutureOrPresent LocalDate fechaFin, UsuarioEntity usuarioNumeroDocumento) {
        super(id, estado, fechaInicio, fechaFin, usuarioNumeroDocumento);
    }
}
