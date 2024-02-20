package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data 
public class IntegranteSemilleroActualizarDTO {
    @NotNull(message = "El id del integrante del semillero es necesario para su actualización")
    private Integer id;
    @NotNull(message = "El estado no puede ser nulo")
    private EstadoIntegranteSemillero estado;

    private LocalDate fechaRetiro;
    @NotNull(message = "El rol del integrante del semillero es necesario para su actualización")
    private Integer rolSemilleroId;

}
