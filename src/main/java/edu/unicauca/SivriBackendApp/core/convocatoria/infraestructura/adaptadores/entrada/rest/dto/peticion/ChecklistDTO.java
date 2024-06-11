package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest.dto.peticion;


import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.EtapaDocumento;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ResponsableDocumento;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ChecklistDTO {

    @NotNull(message = "El documento debe contener un ID valido")
    private Long documentoId;

    @NotNull(message = "Debe seleccionar una Etapa del Documento")
    private EtapaDocumento etapaDocumento;

    @NotNull(message = "Debe seleccionar un responsable")
    private ResponsableDocumento responsableDocumento;

    @PositiveOrZero(message = "La cantidad debe ser un numero positivo")
    private int cantidad;

    @FutureOrPresent(message = "La fecha de Inicio no puede ser en el pasado")
    private boolean obligatorio;

}
