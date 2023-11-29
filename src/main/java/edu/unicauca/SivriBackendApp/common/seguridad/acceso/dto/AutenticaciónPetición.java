package edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutenticaciónPetición {

  @NotBlank(message = "El correo electrónico no puede estar en blanco")
  @Email(message = "Formato de correo electrónico inválido")
  private String email;

  @NotBlank(message = "La contraseña no puede estar en blanco")
  @Size(min = 3, max = 50, message = "La contraseña debe tener entre 5 y 50 caracteres")
  private String password;
}
