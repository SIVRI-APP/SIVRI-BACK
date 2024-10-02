package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "facultad")
@Data
public class FacultadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facultad_seq")
    @SequenceGenerator(name = "facultad_seq", sequenceName = "facultad_seq", initialValue = 10, allocationSize = 1)
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
