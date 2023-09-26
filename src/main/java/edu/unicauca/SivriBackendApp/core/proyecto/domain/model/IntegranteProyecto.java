package edu.unicauca.SivriBackendApp.core.proyecto.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IntegranteProyecto {

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
