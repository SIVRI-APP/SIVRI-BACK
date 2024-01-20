package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "integrante_semillero",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"usuarioId", "rolId", "fechaIngreso"})
        })
@Data
public class IntegranteSemilleroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIntegranteSemillero")
    private Integer id;

    @Column(length = 9)
    @Enumerated(EnumType.STRING)
    private EstadoIntegranteSemillero estado;

    @PastOrPresent
    private LocalDate fechaIngreso;

    @PastOrPresent
    @Column(nullable = true)
    private LocalDate fechaRetiro;

    //relacion *a1 rolSemillero
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "rolId")
    private RolSemilleroEntity rolSemillero;

    //relacion *a1 semillero
    //@JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
   // @MapsId("semilleroId")
    @JoinColumn(name = "semilleroId")
    private SemilleroEntity semillero;

    //relacion *a1 usuario
    //@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private UsuarioEntity usuario;
}
