package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.EstadoIntegranteGrupo;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "integrante_grupo")
@Data
public class IntegranteGrupoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 9,nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoIntegranteGrupo estado;
    @PastOrPresent
    private LocalDate fechaInicio;
    @PastOrPresent
    private LocalDate fechaFin;

    //relacion *a1 con rolgrupo
    @ManyToOne(optional = false)
    @JoinColumn(name = "rolGrupoId")
    private RolGrupoEntity rolGrupo;

    //relacion *a1 con entidad grupo
    @ManyToOne()
    @JoinColumn(name = "grupoId")
    @JsonBackReference
    private GrupoEntity grupo;
    //TODO USUARIO
    //relacion 1a1 con entidad usuario aqui esta la foranea
    /*@OneToOne
    @JoinColumn(name = "usuarioNumeroDocumento")
    private UsuarioEntity usuario;
*/

}
