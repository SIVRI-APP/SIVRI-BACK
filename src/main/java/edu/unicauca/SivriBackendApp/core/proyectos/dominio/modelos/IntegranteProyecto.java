package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import lombok.*;

import java.time.LocalDate;

@Data
public class IntegranteProyecto {

    private Integer id;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private Boolean estado;

    private Usuario usuario;

    private Proyecto proyecto;

    private RolProyecto rolProyecto;
}
