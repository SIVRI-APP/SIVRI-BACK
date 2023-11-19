package edu.unicauca.SivriBackendApp.core.grupo.application.dto.request;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoEstado;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class GrupoActualizarPorApoyoDTO {
    //@NotNull(message = "el id es obligatorio")
    //private Integer id;
    @NotNull(message = "el nombre del grupo no puede ser nulo.")
    @NotEmpty(message = "el nombre del grupo no puede ser nulo.")
    @NotBlank(message = "Nombre Invalido")
    @Size(max = 200, message = "el nombbre del grupo debe ser menor a 200 caracteres")
    private String nombre;
    @NotNull(message = "la facultad no puede ser nula.")

    private Integer idFacultad;
    @NotNull(message = "la direccion no puede ser nula")
    @NotEmpty(message = "la direccion no puede ser nula")
    @NotBlank(message = "Dato Invalido")
    private String direccion;
    @Size(min = 7,max = 14,message = "el numero de telefono debe estar entre 7 14 digitos numericos")
    private String telefono;
    @Email(message = "el correo debe terminar en @unicauca.edu.co")
    @NotNull(message = "el correo no puede ser nulo.")
    @NotEmpty(message = "el correo no puede ser nulo.")
    private String email;
    private String sitioWeb;
    private String escalafonColciencias;
    @NotEmpty(message = "Campo Obligatorio")
    @NotBlank(message = "Dato Invalido")
    private String direccionGrupLac;
    private String codigoColciencias;
    //@NotNull(message = "la fecha de creacion de un grupo no puede ser nula")
    //@PastOrPresent(message = "la fecha del grupo puede ser igual a la fecha actual o anterior")
    //private LocalDate fechaCreacion;
    private GrupoEstado estado;
    private String centroInvestigaciones;
    @NotEmpty(message = "Campo Obligatorio")
    @NotBlank(message = "Dato Invalido")
    @Size(max = 1500, message = "Caracteres Excedidos")
    private String mision;
    @NotEmpty(message = "Campo Obligatorio")
    @NotBlank(message = "Dato Invalido")
    @Size(max = 1500, message = "Caracteres Excedidos")
    private String vision;
    @NotEmpty(message = "Campo Obligatorio")
    @NotBlank(message = "Dato Invalido")
    @Size(max = 1500, message = "Caracteres Excedidos")
    private String objetivo;
    @NotEmpty(message = "Campo Obligatorio")
    @NotBlank(message = "Dato Invalido")
    @Size(max = 1500, message = "Caracteres Excedidos")
    private String realizaciones;
    @NotEmpty(message = "Campo Obligatorio")
    @NotBlank(message = "Dato Invalido")
    @Size(max = 1500, message = "Caracteres Excedidos")
    private String perspectivas;

}
