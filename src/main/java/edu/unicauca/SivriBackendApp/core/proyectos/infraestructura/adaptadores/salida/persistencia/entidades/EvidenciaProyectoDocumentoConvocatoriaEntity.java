package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;


import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.DocumentoConvocatoriaEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "evidencia_proyecto_documento_convocatoria")
@Data
public class EvidenciaProyectoDocumentoConvocatoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyectoId")
    private ProyectoEntity proyecto;

    @ManyToOne()
    @JoinColumn(name = "DocumentoConvocatoriaId")
    private DocumentoConvocatoriaEntity documentoConvocatoria;

    @Column(length = 256)
    private String nombre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvidenciaProyectoDocumentoConvocatoriaEntity that = (EvidenciaProyectoDocumentoConvocatoriaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
