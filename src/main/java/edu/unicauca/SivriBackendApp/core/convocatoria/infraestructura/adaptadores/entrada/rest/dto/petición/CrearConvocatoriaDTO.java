package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest.dto.petición;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ConvocatoriaEstado;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CrearConvocatoriaDTO {

    @Size(min = 5, max = 250, message = "El nombre de la convocatoria debe contener mínimo 5 y máximo 250 caracteres")
    private String nombre;

    @Size(min = 5, max = 250, message = "Los objetivos de la convocatoria debe contener mínimo 5 y máximo 250 caracteres")
    private String objetivos;

    @Size(min = 5, max = 250, message = "El nombre del oferente debe contener mínimo 5 y máximo 90 caracteres")
    private String oferente;

    @FutureOrPresent(message = "La fecha de Inicio no puede ser en el pasado")
    private LocalDate fechaInicio;

    @FutureOrPresent(message = "La fecha de fin no puede ser en el pasado")
    private LocalDate fechaFin;

    @NotNull(message = "El estado de la convocatoria no puede ser nulo")
    private ConvocatoriaEstado estado;

    @NotNull(message = "El ID del tipo de convocatoria no puede ser nulo")
    @Positive(message = "El ID del tipo de convocatoria no puede ser negativo")
    private Long tipoConvocatoriaId;
}
