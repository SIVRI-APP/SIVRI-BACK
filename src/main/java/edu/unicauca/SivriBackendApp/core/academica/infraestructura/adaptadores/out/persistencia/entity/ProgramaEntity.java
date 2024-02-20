package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "programa")
@Data
public class ProgramaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "departamentoId")
    private DepartamentoEntity departamento;

    //relacion *a* con semillero
    /* @ManyToMany(mappedBy = "programas")
    private List<SemilleroEntity> semilleros;
    */
    //TODO usuario
    /*@OneToMany(mappedBy = "programa", fetch = FetchType.LAZY)
    private List<RolPosgradoEntity> usuariosPosgrado;

    @OneToMany(mappedBy = "programa", fetch = FetchType.LAZY)
    private List<RolPregradoEntity> usuariosPregrado;*/
}
