package edu.unicauca.SivriBackendApp.core.usuario.application.dto.response;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.EstadoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.RolUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioValidarExistenciaDTO {

    private String numeroDocumento;

    private TipoDocumento tipoDocumento;

    private Sexo sexo;

    private EstadoUsuario estado;

    private String nombres;

    private String apellidos;

    private String telefono;

    private String correo;

    private List<RolUsuario> rolesDeUsuario;
}
