package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
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

    @Column(nullable = false)
    private Boolean estado;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioId", nullable = false)
    private UsuarioEntity usuario;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "proyectoId", nullable = false)
    @JsonBackReference
    private ProyectoEntity proyecto;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "rolId", nullable = false)
    @JsonManagedReference
    private RolProyectoEntity rolProyecto;
}
