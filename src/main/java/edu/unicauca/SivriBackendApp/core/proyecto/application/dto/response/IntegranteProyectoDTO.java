package edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.RolProyecto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IntegranteProyectoDTO {

    private Integer id;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private String estado;

    private Proyecto proyecto;
//
//    @ManyToOne(optional = false, fetch = FetchType.EAGER)
//    @JoinColumn(name = "usuarioId", nullable = false)
//    private UsuarioEntity usuario;
//
    private RolProyecto rolProyecto;
}
