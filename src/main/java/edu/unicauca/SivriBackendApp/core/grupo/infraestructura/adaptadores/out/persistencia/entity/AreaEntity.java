package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "area")
@Data
public class AreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idArea;
    @Column(length = 50, nullable = false)
    private String area;


    //relacion 1a* con entidad subarea
    @OneToMany(mappedBy = "area",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<SubAreaEntity> subareas;

    @Override
    public String toString() {
        return "AreaEntity{" +
                "idArea=" + idArea +
                ", area='" + area + '\'' +
                '}';
    }
}
