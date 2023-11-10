package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "sub_area")
@Data
public class SubAreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubArea;
    @Column(length = 60,nullable = false)
    private String subArea;

    //relacion *a1 con entidad Area opcional = false indica que la relacion es obligatoria
    @ManyToOne(optional = false)
    @JoinColumn(name = "idArea")
    @JsonManagedReference
    private AreaEntity area;

    //relacion 1a* con entidad disciplina
    @OneToMany(mappedBy = "subArea",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<DisciplinaEntity> disciplinas;

    @Override
    public String toString() {
        return "SubAreaEntity{" +
                "idSubArea=" + idSubArea +
                ", subArea='" + subArea + '\'' +
                ", idArea=" + area +
                '}';
    }
}
