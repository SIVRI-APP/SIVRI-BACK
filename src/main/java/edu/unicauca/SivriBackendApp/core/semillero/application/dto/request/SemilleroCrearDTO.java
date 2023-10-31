package edu.unicauca.SivriBackendApp.core.semillero.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SemilleroCrearDTO {
    @NotNull(message = "el nombre del semillero no puede ser nulo.")
    @NotEmpty(message = "el nombre del semillero no puede ser nulo")
    @Size(max = 200, message = "el nombre del semillero debe ser menor a 200 caracteres")
    @NotBlank(message = "Nombre invalido")
    private String nombre;
    @NotNull(message = "el id del grupo no puede ser nulo.")
    private Integer grupoId;
    @NotNull(message = "el campo del mentor no puede ser nulo.")
    @NotEmpty(message = "el campo del mentor no puede ser nulo")
    @Size(min = 4,max = 14,message = "el documento del mentor debe estar entre 4 y 14 caracteres")
    private String mentorId;

}
