package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "integrante_grupo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IntegranteGrupoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 9,nullable = false)
    private String estado;
    @PastOrPresent
    private LocalDate fechaInicio;
    @PastOrPresent
    private LocalDate fechaFin;

    //relacion *a1 con rolgrupo
    @ManyToOne(optional = false)
    @JoinColumn(name = "rolGrupoId")
    private RolGrupoEntity rolGrupoId;

    //relacion *a1 con entidad grupo
    @ManyToOne(optional = false)
    @JoinColumn(name = "grupoId")
    private GrupoEntity grupos;

    //relacion 1a1 con entidad usuario aqui esta la foranea
    @OneToOne
    @JoinColumn(name = "usuarioNumeroDocumento")
    private UsuarioEntity usuario;


}
