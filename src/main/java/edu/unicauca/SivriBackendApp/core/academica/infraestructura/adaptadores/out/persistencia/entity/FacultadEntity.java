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



    //@OneToMany(mappedBy = "facultad", cascade = CascadeType.REMOVE)
    //private List<DepartamentoEntity> departamentos;

    @Override
    public String toString() {
        return "FacultadEntity{" +
                "idFacultad=" + idFacultad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
