package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.RolDocenteEntity;
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
    @JsonBackReference
    private FacultadEntity facultad;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<ProgramaEntity> programas;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<RolDocenteEntity> usuariosDocente;
}
