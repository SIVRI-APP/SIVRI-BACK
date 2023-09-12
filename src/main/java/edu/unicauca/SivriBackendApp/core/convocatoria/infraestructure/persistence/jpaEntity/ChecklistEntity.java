package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "checklist")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChecklistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId("id")
    @JoinColumn(name = "tipoFinanciacionId")
    @JsonBackReference
    private TipoFinanciacionEntity tipoFinanciacion;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId("id")
    @JoinColumn(name = "documentacionId")
    @JsonManagedReference
    private DocumentacionEntity documentacion;
}

