package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.EstadoIntegranteSemillero;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "integrante_semillero",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {/*"usuarioNumeroDocumento",*/ "rolId", "fechaIngreso"})
        })
@Data
public class IntegranteSemilleroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIntegranteSemillero;

    @Column(length = 9)
    @Enumerated(EnumType.STRING)
    private EstadoIntegranteSemillero estado;

    @Column(length = 4)
    private String semestre;

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
    @JsonManagedReference
    @ManyToOne
    @MapsId("semilleroId")
    @JoinColumn(name = "semilleroId")
    private SemilleroEntity semillero;

    //TODO USUARIO
    //relacion *a1 usuario
    /*@JsonManagedReference
    @ManyToOne
    @MapsId("usuarioNumeroDocumento")
    @JoinColumn(name = "usuarioNumeroDocumento")
    private UsuarioEntity usuario;*/
}
