package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "checklist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChecklistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @MapsId("id")
    @JoinColumn(name = "tipoFinanciacionId")
    private TipoFinanciacionEntity tipoFinanciacion;

    @ManyToOne(optional = false)
    @MapsId("id")
    @JoinColumn(name = "documentacionId")
    private DocumentacionEntity documentacion;
}

