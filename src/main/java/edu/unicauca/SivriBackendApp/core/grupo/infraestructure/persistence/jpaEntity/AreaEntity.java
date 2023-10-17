package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "area")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArea;
    @Column(length = 50, nullable = false)
    private String area;


    //relacion 1a* con entidad subarea
    @OneToMany(mappedBy = "area",fetch = FetchType.LAZY)
    @JsonBackReference
    //@JsonIgnoreProperties
    private List<SubAreaEntity> subareas;

    @Override
    public String toString() {
        return "AreaEntity{" +
                "idArea=" + idArea +
                ", area='" + area + '\'' +
                '}';
    }
}
