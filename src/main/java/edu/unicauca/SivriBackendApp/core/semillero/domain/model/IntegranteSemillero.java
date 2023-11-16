package edu.unicauca.SivriBackendApp.core.semillero.domain.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class IntegranteSemillero {
    private Integer id;
    private EstadoIntegranteSemillero estado;
    private String semestre;
    private LocalDate fechaIngreso;
    private LocalDate fechaRetiro;
    private Integer semilleroId;
    private String numeroDocumento;
    private RolSemillero rolSemillero;

}
