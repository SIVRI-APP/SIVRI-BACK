package edu.unicauca.SivriBackendApp.core.usuario.dominio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSolicitud {

    private Long id;

    private String correo;

    private TipoDocumento tipoDocumento;

    private String numeroDocumento;

    private Sexo sexo;

    private EstadoSolicitudUsuario estado;

    private TipoUsuario tipoUsuario;

    private String nombres;

    private String apellidos;

    private String telefono;

    private String cvLac;

    private Long facultadId;

    private Long departamentoId;

    private Long programaId;
}
