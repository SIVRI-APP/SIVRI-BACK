package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "documento_semillero")
@Data
public class DocumentoSemilleroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 85)
    @Enumerated(EnumType.STRING)
    private TipoDocumentoSemillero tipo;
    @Column(length = 85)
    private String rutaDocumento;
    @Column(length = 100)
    private String observacion;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private EstadoDocumentoSemillero estado;
    @Column(length = 50)
    private LocalDate fechaRegistro;

//relacion *a1 semillero
    @ManyToOne(optional = false)
    @JoinColumn(name = "semilleroId")
    private SemilleroEntity semillero;
    //relacion 1a* con entidad semilleroDOcumentacion
    //@OneToMany(mappedBy = "documentoSemillero", fetch = FetchType.LAZY)
    //private List<SemilleroDocumentacionEntity> documentos;
}
