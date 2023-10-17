package edu.unicauca.SivriBackendApp.core.grupo.application.dto.response;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.EstadoIntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.RolGrupo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.Usuario;
import lombok.Data;

import java.time.LocalDate;
@Data
public class IntegranteGrupoObtenerDTO {
    private Integer id;
    private EstadoIntegranteGrupo estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ObtenerRolesGrupoDTO rolGrupo;
    private Usuario usuario;
    private String nombre;
    private Grupo grupo;
}
