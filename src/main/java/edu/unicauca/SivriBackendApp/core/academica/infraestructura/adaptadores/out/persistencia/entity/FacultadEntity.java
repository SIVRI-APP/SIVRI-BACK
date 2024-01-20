package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.GrupoEntity;
import jakarta.persistence.*;
import lombok.Data;

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
