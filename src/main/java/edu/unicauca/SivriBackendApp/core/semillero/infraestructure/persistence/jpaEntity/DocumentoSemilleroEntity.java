package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "documento_semillero")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoSemilleroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 85)
    private String avalDepartamento;
    @Column(length = 85)
    private String otros;
    @Column(length = 100)
    private String observacion;
    @Column(length = 20)
    private String estado;

    //relacion 1a* con entidad semilleroDOcumentacion
    @OneToMany(mappedBy = "documentoSemillero", fetch = FetchType.LAZY)
    private List<SemilleroDocumentacionEntity> documentos;
}
