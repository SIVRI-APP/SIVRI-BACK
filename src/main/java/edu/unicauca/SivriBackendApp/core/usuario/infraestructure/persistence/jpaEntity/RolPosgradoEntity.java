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
public class RolPosgradoEntity extends RolAcademicoEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "programaId")
    private ProgramaEntity programa;

    public RolPosgradoEntity(Integer id, String nombre, List<RolUsuarioEntity> rolDeUsuarios, ProgramaEntity programa) {
        super(id, nombre, rolDeUsuarios);
        this.programa = programa;
    }
}
