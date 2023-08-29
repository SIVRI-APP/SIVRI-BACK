package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.DocenteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "departamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
    private List<DocenteEntity> usuariosDocente;
}
