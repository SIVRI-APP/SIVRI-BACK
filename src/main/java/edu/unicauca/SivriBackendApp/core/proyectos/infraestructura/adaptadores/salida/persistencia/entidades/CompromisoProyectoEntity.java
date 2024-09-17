package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "compromiso_proyecto")
@Getter
@Setter
@NoArgsConstructor
public class CompromisoProyectoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(optional = false)
    private ProyectoEntity proyecto;

    @ManyToOne(optional = false)
    private ProductoProyectoEntity producto;

    @ManyToOne(optional = false)
    private IntegranteProyectoEntity responsable;

    @OneToMany(mappedBy="compromisoProyecto")
    private List<EvidenciaCompromisoEntity> evidencias;

}
