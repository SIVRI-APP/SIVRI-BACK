package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoDocumentoSemillero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Optional;

@Data
public class DocumentoSemilleroActualizarDTO {

    private String observacion;
    private String estado;
}
