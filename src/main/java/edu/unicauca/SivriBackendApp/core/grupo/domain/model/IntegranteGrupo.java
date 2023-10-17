package edu.unicauca.SivriBackendApp.core.grupo.domain.model;

import edu.unicauca.SivriBackendApp.core.usuario.domain.Usuario;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IntegranteGrupo {
    private Integer id;
    private EstadoIntegranteGrupo estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private RolGrupo rolGrupo;
    private Usuario usuario;
    private Grupo grupo;

}
