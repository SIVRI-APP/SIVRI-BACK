package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IntegranteSemilleroObtenerDTO {
    private Integer id;
    private EstadoIntegranteSemillero estado;
    private LocalDate fechaIngreso;
    private LocalDate fechaRetiro;
    private Semillero semillero;
    private Usuario usuario;
    private RolesSemilleroObtenerDTO rolSemillero;

}
