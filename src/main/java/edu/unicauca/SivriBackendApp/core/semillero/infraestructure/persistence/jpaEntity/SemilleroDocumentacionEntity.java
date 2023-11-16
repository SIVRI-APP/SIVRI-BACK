package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "semillero_documentacion")
@Data
public class SemilleroDocumentacionEntity {
    //relacion *a1 de tabla semillero y tambien es primaria
    @Id
    @ManyToOne
    @JoinColumn(name = "semilleroId", referencedColumnName = "id")
    private SemilleroEntity semillero;
    //relacion *a1 tabla documentos y es primaria
    @Id
    @ManyToOne
    @JoinColumn(name = "idDocumentoSemillero", referencedColumnName = "id")
    private DocumentoSemilleroEntity documentoSemillero;
    @PastOrPresent
    private LocalDate fecha;

}
