package edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response;

import lombok.Data;

@Data
public class ObtenerProyectoResponse {
    private int id;
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
}
