package edu.unicauca.SivriBackendApp.core.semillero.application.dto.response;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.SemilleroEstado;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SemilleroObtenerDTO {
    private Integer semilleroId;
    private String nombre;
    private SemilleroEstado estado;
    private LocalDate fechaCreacion;
    private String sede;
    private String objetivo;
    private String mision;
    private String vision;
    private Integer grupoId;
}
