package edu.unicauca.SivriBackendApp.core.grupo.application.dto.request;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoEstado;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
@Data
public class GrupoActualizarPorApoyoDTO {
    @NotNull(message = "el id es obligatorio")
    private Integer id;
    @NotNull(message = "el nombre del grupo no puede ser nulo.")
    @Size(max = 200, message = "el nombbre del grupo debe ser menor a 200 caracteres")
    private String nombre;
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
    @NotNull(message = "la fecha de creacion de un grupo no puede ser nula")
    @PastOrPresent(message = "la fecha del grupo puede ser igual a la fecha actual o anterior")
    private LocalDate fechaCreacion;
    private GrupoEstado estado;
    private String centroInvestigaciones;
    private String mision;
    private String vision;
    private String objetivo;
    private String realizaciones;
    private String perspectivas;

}
