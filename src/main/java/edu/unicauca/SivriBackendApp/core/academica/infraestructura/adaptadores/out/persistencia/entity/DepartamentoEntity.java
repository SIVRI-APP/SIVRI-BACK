package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "departamento")
@Data
public class DepartamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "facultadId")
    private FacultadEntity facultad;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.REMOVE)
    private List<ProgramaEntity> programas;
    //TODO usuario
    /*@OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
    private List<RolDocenteEntity> usuariosDocente;
*/}
