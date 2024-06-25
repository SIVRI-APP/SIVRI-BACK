package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistroUsuarioDTO {

    @Email(message = "Se debe digitar un correo valido")
    @Size(min = 8, max = 100, message = "El correo del usuario debe contener mínimo 8 y máximo 60 caracteres")
    private String correo;

    @NotNull(message = "El tipo de documento no puede ser nulo")
    private TipoDocumento tipoDocumento;

    @Size(min = 5, max = 100, message = "El numero de documento debe contener mínimo 5 y máximo 45 caracteres")
    private String numeroDocumento;

    @NotNull(message = "El sexo del usuario no puede ser nulo")
    private Sexo sexo;

    @NotNull(message = "Debe seleccionar un tipo valido para el usuario")
    private TipoUsuario tipoUsuario;

    @Size(min = 1, max = 100, message = "El nombre del usuario debe contener mínimo 1 y máximo 100 caracteres")
    private String nombre;

    @Size(min = 1, max = 100, message = "El apellido del usuario debe contener mínimo 1 y máximo 100 caracteres")
    private String apellido;

    @Size(min = 5, max = 100, message = "El teléfono del usuario debe contener mínimo 5 y máximo 45 caracteres")
    private String telefono;

    private String cvLac;

    private Integer programaId;

    @Size(max = 1000, message = "La nota no puede exceder los 1000 caracteres")
    private String nota;

    private String organismoDeInvestigacion;

    private Integer organismoDeInvestigacionId;

    private Integer rolId;
}
