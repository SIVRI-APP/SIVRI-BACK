package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoCompromisoProyectoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "evidencia_compromiso")
@Getter
@Setter
public class EvidenciaCompromisoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evidencia_compromiso_seq")
    @SequenceGenerator(name = "evidencia_compromiso_seq", sequenceName = "evidencia_compromiso_seq", initialValue = 10, allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EstadoCompromisoProyectoEnum estado;

    @Column(length = 200)
    private String rutaAlmacenamiento;

    @ManyToOne(optional = false)
    private CompromisoProyectoEntity compromisoProyecto;
}
