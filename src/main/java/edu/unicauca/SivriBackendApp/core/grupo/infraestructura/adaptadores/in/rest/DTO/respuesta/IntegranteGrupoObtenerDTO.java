package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.EstadoIntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
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

    private Grupo grupo;
}
