package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoDocumentoSemillero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DocumentoSemilleroActualizarDTO {
    @NotEmpty(message = "la observacion no puede ser nula")
    @NotBlank(message = "Dato Invalido")
    private String observacion;
    private EstadoDocumentoSemillero estado;
}
