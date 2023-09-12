package edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.request;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.ConvocatoriaEstado;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConvocatoriaActualizarDTO {

    private Long id;

    private String nombre;

    private String objetivos;

    private String oferente;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private boolean recurrente;

    private ConvocatoriaEstado estado;

    private long tipoFinanciacion;

}
