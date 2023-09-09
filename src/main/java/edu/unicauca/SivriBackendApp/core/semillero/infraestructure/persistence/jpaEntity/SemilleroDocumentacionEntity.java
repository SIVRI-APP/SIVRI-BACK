package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "semillero_documentacion")
@Getter
@Setter
@AllArgsConstructor
public class SemilleroDocumentacionEntity {
    //relacion *a1 de tabla semillero y tambien es primarya
    @Id
    @ManyToOne
    @JoinColumn(name = "semilleroId", referencedColumnName = "id")
    //@PrimaryKeyJoinColumn(name = "organismoDeInvestigacionId")
    private SemilleroEntity idSemillero;
    //relacion *a1 tabla documentos y es primaria
    @Id
    @ManyToOne
    @JoinColumn(name = "idDocumentoSemillero", referencedColumnName = "id")
    private DocumentoSemilleroEntity idDocumento;
    @PastOrPresent
    private LocalDate fecha;

}
