package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionSemillero {
    private Integer id;
    private Long funcionarioId;
    private Integer semilleroId;
    private String observacion;
    private LocalDate fecha;
}
