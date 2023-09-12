package edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.request;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.ConvocatoriaEstado;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConvocatoriaActualizarDTO {

    @NotNull(message = "El id de la Convocatoria es necesario para su actualización")
    private Long id;

    @NotNull(message = "El nombre de la Convocatoria no puede ser Nulo")
    @Size(min = 2, max = 250, message = "El nombre de la Convocatoria debe estar entre 2 y 250 caracteres")
    private String nombre;

    private String objetivos;

    private String oferente;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private boolean recurrente;

    private ConvocatoriaEstado estado;

    private long tipoFinanciacion;

}
