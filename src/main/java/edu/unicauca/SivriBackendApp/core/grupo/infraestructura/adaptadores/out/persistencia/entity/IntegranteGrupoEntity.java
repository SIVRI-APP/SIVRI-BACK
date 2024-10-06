package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.EstadoIntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "integrante_grupo")
@Data
public class IntegranteGrupoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "integrante_grupo_seq")
    @SequenceGenerator(name = "integrante_grupo_seq", sequenceName = "integrante_grupo_seq", initialValue = 7, allocationSize = 1)
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

    //relacion *a1 con entidad usuario aqui esta la foranea
    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private UsuarioEntity usuario;


}
