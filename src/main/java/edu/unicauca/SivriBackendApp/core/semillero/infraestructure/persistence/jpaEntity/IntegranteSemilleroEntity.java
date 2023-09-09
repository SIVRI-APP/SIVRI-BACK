package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "integrante_semillero")
@Getter
@Setter
@AllArgsConstructor
public class IntegranteSemilleroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIntegranteSemillero;
    @Column(length = 9)
    private String estado;
    @Column(length = 4)
    private String semestre;
    @PastOrPresent
    private LocalDate fechaIngreso;
    @PastOrPresent
    @Column(nullable = true)
    private LocalDate fechaRetiro;
    //relacion *a1 rolSemillero
    @ManyToOne
    @JoinColumn(name = "rolId")
    private RolSemilleroEntity idRol;
    //relacion *a1 semillero
    @ManyToOne
    @JoinColumn(name = "semilleroId")
    private SemilleroEntity idSemillero;
    //relacion *a1 usuario
    @ManyToOne
    @JoinColumn(name = "usuarioNumeroDocumento")
    private UsuarioEntity idUsuario;
}
