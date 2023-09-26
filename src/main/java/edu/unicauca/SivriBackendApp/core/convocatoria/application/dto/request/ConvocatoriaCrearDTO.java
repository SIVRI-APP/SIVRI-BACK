package edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.request;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.ConvocatoriaEstado;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConvocatoriaCrearDTO {

    @NotNull(message = "El nombre de la Convocatoria no puede ser Nulo")
    @Size(min = 2, max = 250, message = "El nombre de la Convocatoria debe estar entre 2 y 250 caracteres")
    private String nombre;

    @Size(max = 250, message = "Los Objetivos de la Convocatoria no pueden superar los 250 caracteres")
    private String objetivos;

    @Size(max = 90, message = "El Oferente de la Convocatoria no pueden superar los 90 caracteres")
    private String oferente;

    @FutureOrPresent(message = "La fecha inicio de la Convocatoria no puede ser anterior a la fecha actual")
    private LocalDate fechaInicio;

    @FutureOrPresent(message = "La fecha fin de la Convocatoria no puede ser anterior a la fecha actual")
    private LocalDate fechaFin;

    @NotNull(message = "Se debe especificar si la Convocatoria es recurrente o no")
    private boolean recurrente;

    @NotNull(message = "Se debe especificar el Estado de la Convocatoria")
    private ConvocatoriaEstado estado;

    @NotNull(message = "La convocatoria debe estar asociada a un tipo de Financiación")
    @Positive(message = "La convocatoria debe estar asociada a un tipo de Financiación Valido")
    private long tipoFinanciacion;

}
