package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "documentacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "documentacion", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<ChecklistEntity> checklist;
}
