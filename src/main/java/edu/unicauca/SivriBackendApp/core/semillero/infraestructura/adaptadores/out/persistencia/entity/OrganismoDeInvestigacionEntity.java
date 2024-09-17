package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "organismo_de_investigacion")
@Data
public abstract class OrganismoDeInvestigacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable=false, length = 200,unique = true)
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
