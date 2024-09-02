package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "integrante_proyecto")
@Getter
@Setter
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
    private ProyectoEntity proyecto;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "rolId", nullable = false)
    private RolProyectoEntity rolProyecto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegranteProyectoEntity that = (IntegranteProyectoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
