package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;


import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.DocumentoConvocatoriaEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "evidencia_proyecto_documento_convocatoria")
@Data
public class EvidenciaProyectoDocumentoConvocatoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "proyectoId")
    private ProyectoEntity proyecto;

    @ManyToOne()
    @JoinColumn(name = "DocumentoConvocatoriaId")
    private DocumentoConvocatoriaEntity DocumentoConvocatoria;

    @Column(length = 256)
    private String nombre;

}
