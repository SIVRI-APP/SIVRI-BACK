package edu.unicauca.SivriBackendApp.core.semillero.application.dto.response;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.EstadoIntegranteSemillero;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IntegranteSemilleroObtenerDTO {
    private Integer id;
    private EstadoIntegranteSemillero estado;
    private String semestre;
    private LocalDate fechaIngreso;
    private LocalDate fechaRetiro;
    private Integer semilleroId;
    private String numeroDocumento;
    private RolesSemilleroObtenerDTO rolSemillero;

}
