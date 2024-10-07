package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest.DTO.respuesta;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Departamento;
import lombok.Data;

@Data
public class ProgramaDTO {
    private Integer id;
    private String nombre;
    private Departamento departamento;

}
