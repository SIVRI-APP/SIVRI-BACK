package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @OneToMany(mappedBy = "idArea",fetch = FetchType.LAZY)
    private List<SubAreaEntity> subareas;
}
