package edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.Usuario;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IntegranteGrupo {
    private Integer id;
    private EstadoIntegranteGrupo estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private RolGrupo rolGrupo;
    private Usuario usuario;
    private Grupo grupo;

}
