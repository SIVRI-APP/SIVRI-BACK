package edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO que representa la petición de autenticación de un usuario.
 */
@Data
public class AutenticaciónPetición {

  /**
   * Correo electrónico del usuario.
   */
  @NotBlank(message = "El correo electrónico no puede estar en blanco")
  @Email(message = "Formato de correo electrónico inválido")
  private String email;

  /**
   * Contraseña del usuario.
   */
  @NotBlank(message = "La contraseña no puede estar en blanco")
  @Size(min = 3, max = 50, message = "La contraseña debe tener entre 5 y 50 caracteres")
  private String password;
}