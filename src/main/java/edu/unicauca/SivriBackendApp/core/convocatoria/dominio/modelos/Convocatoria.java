package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ConvocatoriaEstado;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Convocatoria {

    private Long id;

    private String nombre;

    private String objetivos;

    private String oferente;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private ConvocatoriaEstado estado;

    private TipoConvocatoria tipoConvocatoria;

}
