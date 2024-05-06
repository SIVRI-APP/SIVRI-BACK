package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest.DTO.respuesta;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.Facultad;
import lombok.Data;

@Data
public class DepartamentoDTO {
    private Integer id;
    private String nombre;
    private Facultad facultad;
}
