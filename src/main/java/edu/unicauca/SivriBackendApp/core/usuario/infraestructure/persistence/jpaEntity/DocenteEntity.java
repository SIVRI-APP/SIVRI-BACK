package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.DepartamentoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "docente")
@PrimaryKeyJoinColumn(name = "rolAcademicoId")
@Getter
@Setter
@NoArgsConstructor
public class DocenteEntity extends RolAcademicoEntity{

    @Column(name = "CvLAC")
    private String cvLac;

    @ManyToOne(optional = false)
    @JoinColumn(name = "departamentoId")
    private DepartamentoEntity departamento;

    public DocenteEntity(Integer id, String estado, @FutureOrPresent LocalDate fechaInicio, @FutureOrPresent LocalDate fechaFin, UsuarioEntity usuarioNumeroDocumento, String cvLac, DepartamentoEntity departamento) {
        super(id, estado, fechaInicio, fechaFin, usuarioNumeroDocumento);
        this.cvLac = cvLac;
        this.departamento = departamento;
    }
}
