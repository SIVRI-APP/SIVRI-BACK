package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;


import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.DocumentoConvocatoriaEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "evidencia_proyec_docu_conv")
@Data
public class EvidenciaProyectoDocumentoConvocatoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROYECTO_ID")
    private ProyectoEntity proyecto;

    @ManyToOne()
    @JoinColumn(name = "DOCUMENTO_CONVOCATORIA_ID")
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
