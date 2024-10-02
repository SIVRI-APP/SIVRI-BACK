package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "programa")
@Data
public class ProgramaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "programa_seq")
    @SequenceGenerator(name = "programa_seq", sequenceName = "programa_seq", initialValue = 10, allocationSize = 1)
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
