package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SemilleroActualizarPorMentorDTO {
    @NotNull(message = "el id del semillero es obligatorio")
    private Integer semilleroId;
    @NotNull(message = "el nombre no puede ser nulo.")
    @NotEmpty(message = "el nombre no puede ser nulo.")
    @Size(min = 5,max = 200,message = "el nombre del semillero debe estar entre 5 y 200 caracteres.")
    private String nombre;
    @Email(message = "El correo debe tener el formato ejemplo@unicauca.edu.co")
    private String correo;
    @NotNull(message = "el objetivo no puede ser nulo")
    @NotEmpty(message = "el objetivo no puede ser nulo")
    @Size(max = 1325,message = "el objetivo debe tener un maximo de 1325 caracteres")
    private String objetivo;
    @NotNull(message = "la mision no puede ser nulo")
    @NotEmpty(message = "la mision no puede ser nulo")
    @Size(max = 1163,message = "la mision debe tener un maximo de 1163 caracteres")
    private String mision;
    @NotNull(message = "la vision no puede ser nulo")
    @NotEmpty(message = "la vision no puede ser nulo")
    @Size(max = 1237,message = "la vision debe tener un maximo de 1237 caracteres")
    private String vision;
    private String sede;
    @NotNull(message = "el id del grupo no puede ser nulo.")
    private Integer grupoId;
}
