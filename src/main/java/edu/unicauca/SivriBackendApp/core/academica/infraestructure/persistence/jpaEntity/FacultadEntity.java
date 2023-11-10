package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.GrupoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "facultad")
@Data
public class FacultadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFacultad;

    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;

    //relacion 1a* con entidad grupo
    @OneToMany(mappedBy = "facultad", fetch = FetchType.LAZY)
    private List<GrupoEntity> grupos;

    @OneToMany(mappedBy = "facultad", cascade = CascadeType.REMOVE)
    private List<DepartamentoEntity> departamentos;

    @Override
    public String toString() {
        return "FacultadEntity{" +
                "idFacultad=" + idFacultad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
