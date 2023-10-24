package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.DepartamentoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rol_docente")
@PrimaryKeyJoinColumn(name = "rolAcademicoId")
@Getter
@Setter
@NoArgsConstructor
public class RolDocenteEntity extends RolAcademicoEntity {

    @Column(name = "CvLAC")
    private String cvLac;

    @ManyToOne(optional = false)
    @JoinColumn(name = "departamentoId")
    private DepartamentoEntity departamento;

    public RolDocenteEntity(Integer id, String nombre, List<RolUsuarioEntity> rolDeUsuarios, String cvLac) {
        super(id, nombre, rolDeUsuarios);
        this.cvLac = cvLac;
    }
}
