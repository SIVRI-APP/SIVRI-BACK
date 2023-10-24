package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "rol_usuario")
@Data
public class RolUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Boolean estado;

    @FutureOrPresent
    private LocalDate fechaInicio;

    @FutureOrPresent
    private LocalDate fechaFin;

    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name = "usuarioTipoDocumento", referencedColumnName = "tipoDocumento"),
            @JoinColumn(name = "usuarioNumeroDocumento", referencedColumnName = "numeroDocumento")
    })
    private UsuarioEntity usuario;

    @ManyToOne()
    @JoinColumn(name = "rolAcademicoId")
    private RolAcademicoEntity rolAcademico;
}
