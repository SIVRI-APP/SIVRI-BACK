package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IntegranteSemilleroObtenerDTO {
    private Integer id;
    private EstadoIntegranteSemillero estado;
    private LocalDate fechaIngreso;
    private LocalDate fechaRetiro;
    private Integer semilleroId;
    private Long usuarioId;
    private RolesSemilleroObtenerDTO rolSemillero;

}
