package edu.unicauca.SivriBackendApp.core.usuario.application.dto.request;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistroUsuarioDTO {

    @Email(message = "Se debe digitar un correo valido")
    @Size(min = 8, max = 60, message = "El correo del usuario debe contener minimo 8 y maximo 60 caracteres")
    private String correo;

    @NotNull(message = "El tipo de documento no puede ser nulo")
    private TipoDocumento tipoDocumento;

    @Size(min = 5, max = 45, message = "El numero de documento debe contener minimo 5 y maximo 45 caracteres")
    private String numeroDocumento;

    @NotNull(message = "El sexo del usuario no puede ser nulo")
    private Sexo sexo;

    @Size(min = 1, max = 100, message = "El nombre del usuario debe contener minimo 1 y maximo 100 caracteres")
    private String nombres;

    @Size(min = 1, max = 100, message = "El apellido del usuario debe contener minimo 1 y maximo 100 caracteres")
    private String apellidos;

    @Size(min = 5, max = 45, message = "El telefono del usuario debe contener minimo 5 y maximo 45 caracteres")
    private String telefono;

    private TipoUsuario tipoUsuario;

    private String cvLac;

    private Long departamentoId;

    private Long facultadId;

    private Long programaId;

    private String rol;
}
