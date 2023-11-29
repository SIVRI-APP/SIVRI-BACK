package edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistroCredencialPetición {

  private String email;
  private String password;
  private Long usuarioId;
}
