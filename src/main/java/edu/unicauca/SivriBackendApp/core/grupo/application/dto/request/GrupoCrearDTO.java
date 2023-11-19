package edu.unicauca.SivriBackendApp.core.grupo.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GrupoCrearDTO {
    @NotNull(message = "el nombre del grupo no puede ser nulo.")
    @NotBlank(message = "nombre invalido")
    @NotEmpty(message = "el nombre del grupo no puede ser nulo.")
    @Size(max = 200, message = "el nombbre del grupo debe ser menor a 200 caracteres")
    private String nombre;
    @NotNull(message = "la fecha de creacion de un grupo no puede ser nula")
    @PastOrPresent(message = "la fecha del grupo puede ser igual a la fecha actual o anterior")
    private LocalDate fechaCreacion;
    @NotNull(message = "el grupo debe estar asociado a un director")
    private String numeroDocumento;

}
