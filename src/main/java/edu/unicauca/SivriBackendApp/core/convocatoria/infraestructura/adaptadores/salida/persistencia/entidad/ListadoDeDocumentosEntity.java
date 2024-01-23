package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.EtapaDocumento;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ResponsableDocumento;
import jakarta.persistence.*;

@Entity
@Table(name = "listado_de_documentos")
public class ListadoDeDocumentosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipoConvocatoriaId")
    private TipoConvocatoriaEntity tipoConvocatoria;

    @ManyToOne(optional = false)
    @JoinColumn(name = "documentoConvocatoriaId")
    private DocumentoConvocatoriaEntity documentoConvocatoria;

    @Enumerated(EnumType.STRING)
    private EtapaDocumento etapaDocumento;

    @Enumerated(EnumType.STRING)
    private ResponsableDocumento responsableDocumento;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private boolean obligatorio;
}
