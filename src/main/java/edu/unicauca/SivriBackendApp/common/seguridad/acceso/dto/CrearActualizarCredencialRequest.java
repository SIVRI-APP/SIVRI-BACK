package edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto;

import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

/**
 * Esta clase representa un objeto de transferencia de datos (DTO) utilizado para crear actualizar credenciales desde la vista pública del front.
 * Contiene los campos necesarios para crear actualizar una credencial en el sistema.
 */
@Data
@Builder
public class CrearActualizarCredencialRequest {

  /**
   * El correo electrónico asociado a la nueva credencial.
   */
  private String passwordRecoveryCode;

  /**
   * La contraseña asociada a la nueva credencial.
   */
  @Size(min = 5, max = 245, message = "La contraseña debe contener entre 5 y 245 caracteres")
  private String password;

  /**
   * La contraseña asociada a la nueva credencial.
   */
  @Size(min = 5, max = 245, message = "La contraseña debe contener entre 5 y 245 caracteres")
  private String repeatPassword;

}
