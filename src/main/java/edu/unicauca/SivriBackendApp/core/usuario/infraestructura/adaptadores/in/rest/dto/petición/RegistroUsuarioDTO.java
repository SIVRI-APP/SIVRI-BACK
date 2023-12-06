package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest.dto.petición;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistroUsuarioDTO {

    @Email(message = "Se debe digitar un correo valido")
    @Size(min = 8, max = 60, message = "El correo del usuario debe contener mínimo 8 y máximo 60 caracteres")
    private String correo;

    @NotNull(message = "El tipo de documento no puede ser nulo")
    private TipoDocumento tipoDocumento;

    @Size(min = 5, max = 45, message = "El numero de documento debe contener mínimo 5 y máximo 45 caracteres")
    private String numeroDocumento;

    @NotNull(message = "El sexo del usuario no puede ser nulo")
    private Sexo sexo;

    @Size(min = 1, max = 100, message = "El nombre del usuario debe contener mínimo 1 y máximo 100 caracteres")
    private String nombres;

    @Size(min = 1, max = 100, message = "El apellido del usuario debe contener mínimo 1 y máximo 100 caracteres")
    private String apellidos;

    @Size(min = 5, max = 45, message = "El teléfono del usuario debe contener mínimo 5 y máximo 45 caracteres")
    private String telefono;

    @NotNull(message = "Debe seleccionar un tipo valido para el usuario")
    private TipoUsuario tipoUsuario;

    @NotNull(message = "EL usuario debe estar asociado a un grupo")
    private Integer grupoId;

    @NotNull(message = "Se debe asignar un rol al usuario")
    private Integer rolGrupoId;

    private String cvLac;

    private Long departamentoId;

    private Long facultadId;

    private Long programaId;

    private String rol;
}
