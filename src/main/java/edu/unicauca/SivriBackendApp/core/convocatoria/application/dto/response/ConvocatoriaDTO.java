package edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.ConvocatoriaEstado;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConvocatoriaDTO {

    private Long id;

    private String nombre;

    private String objetivos;

    private String oferente;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private Boolean recurrente;

    private Boolean eliminadoLogico;

    private ConvocatoriaEstado estado;

    private TipoFinanciacionDTO tipoFinanciacion;

//    @OneToMany(mappedBy = "convocatoria", fetch = FetchType.LAZY)
//    private List<ProyectoEntity> proyectos;
}
