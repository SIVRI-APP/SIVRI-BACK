package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.EstadoIntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import lombok.Data;

import java.time.LocalDate;
@Data
public class IntegranteGrupoObtenerDTO {
    private Integer id;
    private EstadoIntegranteGrupo estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ObtenerRolesGrupoDTO rolGrupo;
    //TODO USUSARIO
    //private Usuario usuario;
    //private String nombre;
    private Grupo grupo;
}
