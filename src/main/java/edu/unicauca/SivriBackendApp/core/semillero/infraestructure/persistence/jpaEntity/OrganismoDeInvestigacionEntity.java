package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "organismo_de_investigacion")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public abstract class OrganismoDeInvestigacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false, length = 200)
    private String nombre;
    @PastOrPresent
    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(length = 1325)
    private String objetivo;
    @Column(length = 1163)
    private String mision;
    @Column(length = 1237)
    private String vision;
}
