package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.OrganismoDeInvestigacionEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "cooperacion")
@Data
public class CooperacionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cooperacion_seq")
    @SequenceGenerator(name = "cooperacion_seq", sequenceName = "cooperacion_seq", initialValue = 20, allocationSize = 1)
    private Long id;

    private Boolean principal;

    private Boolean estado;

    @FutureOrPresent
    private LocalDate fechaInicio;

    @FutureOrPresent
    private LocalDate fechaFin;

    @ManyToOne()
    @JoinColumn(name = "proyectoId")
    @JsonManagedReference
    private ProyectoEntity proyecto;

    @ManyToOne()
    @JoinColumn(name = "organismoDeInvestigacionId")
    @JsonManagedReference
    private OrganismoDeInvestigacionEntity organismoDeInvestigacion;
}
