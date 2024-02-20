package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.petición;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GrupoFormuladoActualizarPorDirectorDTO {
    @NotNull(message = "el id es obligatorio")
    private Integer id;
    @NotNull(message = "la facultad no puede ser nula.")
    private Integer idFacultad;
    @NotNull(message = "la direccion no puede ser nula")
    private String direccion;
    @Size(min = 7,max = 14,message = "el numero de telefono debe estar entre 7 14 digitos numericos")
    private String telefono;
    @Email(message = "el correo debe terminar en @unicauca.edu.co")
    @NotNull(message = "el correo no puede ser nulo.")
    private String email;
    private String sitioWeb;
    private String escalafonColciencias;
    private String direccionGrupLac;
    private String codigoColciencias;
    private String centroInvestigaciones;
    private String mision;
    private String vision;
    private String objetivo;
    private String realizaciones;
    private String perspectivas;
}
