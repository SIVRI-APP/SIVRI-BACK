package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "facultad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacultadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "facultad", cascade = CascadeType.REMOVE)
    private List<DepartamentoEntity> departamentos;
}
