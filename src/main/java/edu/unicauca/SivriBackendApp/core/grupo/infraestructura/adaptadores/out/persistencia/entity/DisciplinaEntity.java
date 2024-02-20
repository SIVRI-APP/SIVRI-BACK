package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "disciplina")
@Data
public class DisciplinaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 160, nullable = false)
    private String disciplina;

    // relacion *a1 con entidad subarea
    @ManyToOne(optional = false)
    @JoinColumn(name = "idSubArea")
    @JsonManagedReference
    private SubAreaEntity subArea;

    // relacion *a* con entidad grupo ESTA relacion esta en la entidad grupo

    @Override
    public String toString() {
        return "DisciplinaEntity{" +
                "id=" + id +
                ", disciplina='" + disciplina + '\'' +
                ", subArea=" + subArea +
                '}';
    }
}
