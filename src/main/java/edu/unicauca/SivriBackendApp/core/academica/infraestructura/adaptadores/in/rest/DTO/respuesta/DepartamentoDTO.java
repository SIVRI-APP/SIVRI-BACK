package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest.DTO.respuesta;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Facultad;
import lombok.Data;

@Data
public class DepartamentoDTO {
    private Integer id;
    private String nombre;
    private Facultad facultad;
}
