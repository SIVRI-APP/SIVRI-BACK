package edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CambioContraseñaPetición {

    private String currentPassword;
    private String newPassword;
    private String confirmationPassword;
}
