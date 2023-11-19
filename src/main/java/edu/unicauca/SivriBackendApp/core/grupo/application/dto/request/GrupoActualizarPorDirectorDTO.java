package edu.unicauca.SivriBackendApp.core.grupo.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class GrupoActualizarPorDirectorDTO {
    //@NotNull(message = "el id es obligatorio")
    //private Integer id;
    //@NotNull(message = "la facultad no puede ser nula.")
    private Integer idFacultad;
    @NotNull(message = "la direccion no puede ser nula")
    @NotEmpty(message = "la direccion no puede ser nula")
    @NotBlank(message = "Dato Invalido")
    private String direccion;
    @Size(min = 7,max = 14,message = "el numero de telefono debe estar entre 7 14 digitos numericos")
    private String telefono;
    @Email(message = "ejemplo correo-> ejemplo@unicauca.edu.co")
    @NotNull(message = "el correo no puede ser nulo.")
    @NotEmpty(message = "el correo no puede ser nulo.")
    private String email;
    private String sitioWeb;
    private String escalafonColciencias;
    @NotEmpty(message = "Campo Obligatorio")
    @NotBlank(message = "Dato Invalido")
    private String direccionGrupLac;
    private String codigoColciencias;
    private String centroInvestigaciones;
    /*@NotEmpty(message = "Campo Obligatorio")
    @NotBlank(message = "Dato Invalido")
    @Size(max = 1500, message = "Caracteres Excedidos")
    */private String mision;
   /* @NotEmpty(message = "Campo Obligatorio")
    @NotBlank(message = "Dato Invalido")
    @Size(max = 1500, message = "Caracteres Excedidos")
   */ private String vision;
   /* @NotEmpty(message = "Campo Obligatorio")
    @NotBlank(message = "Dato Invalido")
    @Size(max = 1500, message = "Caracteres Excedidos")
  */  private String objetivo;
  /*  @NotEmpty(message = "Campo Obligatorio")
    @NotBlank(message = "Dato Invalido")
    @Size(max = 1500, message = "Caracteres Excedidos")
  */  private String realizaciones;
  /*  @NotEmpty(message = "Campo Obligatorio")
    @NotBlank(message = "Dato Invalido")
    @Size(max = 1500, message = "Caracteres Excedidos")
  */  private String perspectivas;

}
