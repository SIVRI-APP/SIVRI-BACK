package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroEstado;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SemilleroObtenerDTO {
    private Integer semilleroId;
    private String nombre;
    private SemilleroEstado estado;
    private LocalDate fechaCreacion;
    private String correo;
    private String sede;
    private String objetivo;
    private String mision;
    private String vision;
    private Integer grupoId;
}
