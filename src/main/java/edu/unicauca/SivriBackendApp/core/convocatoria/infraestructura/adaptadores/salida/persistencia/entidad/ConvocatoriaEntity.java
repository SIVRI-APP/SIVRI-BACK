package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ConvocatoriaEstado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "convocatoria")
@Data
public class ConvocatoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250    , nullable = false)
    private String nombre;

    @Column(length = 250, nullable = false)
    private String objetivos;

    @Column(length = 90, nullable = false)
    private String oferente;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    private ConvocatoriaEstado estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipoConvocatoriaId")
    private TipoConvocatoriaEntity tipoConvocatoriaEntity;
}
