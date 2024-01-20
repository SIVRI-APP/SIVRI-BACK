package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObservacionSemilleroObtenerDTO {
    private Integer id;
    private Integer funcionarioId;
    private Integer semilleroId;
    private String observacion;
    private LocalDate fecha;
}
