package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "integrante_proyecto")
@Data
public class  IntegranteProyectoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @FutureOrPresent
    private LocalDate fechaInicio;

    @FutureOrPresent
    private LocalDate fechaFin;

    @Column(length = 45, nullable = false)
    private String estado;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "proyectoId", nullable = false)
    @JsonBackReference
    private ProyectoEntity proyecto;
//
//    @ManyToOne(optional = false, fetch = FetchType.EAGER)
//    @JoinColumn(name = "usuarioId", nullable = false)
//    private UsuarioEntity usuario;
//
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "rolId", nullable = false)
    @JsonManagedReference
    private RolProyectoEntity rolProyecto;
}
