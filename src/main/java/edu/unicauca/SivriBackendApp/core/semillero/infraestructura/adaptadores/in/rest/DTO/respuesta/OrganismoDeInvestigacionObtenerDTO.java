package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta;

import lombok.Data;

import java.time.LocalDate;
@Data
public class OrganismoDeInvestigacionObtenerDTO {
    private Integer id;
    private String nombre;
    private LocalDate fechaCreacion;
    private String estado;
    private String objetivo;
    private String mision;
    private String vision;

}
