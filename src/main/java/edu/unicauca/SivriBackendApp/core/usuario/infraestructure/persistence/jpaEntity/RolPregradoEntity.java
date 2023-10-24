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
public class RolPregradoEntity extends RolAcademicoEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "programaId")
    private ProgramaEntity programa;

    public RolPregradoEntity(Integer id, String nombre, List<RolUsuarioEntity> rolDeUsuarios, ProgramaEntity programa) {
        super(id, nombre, rolDeUsuarios);
        this.programa = programa;
    }
}
