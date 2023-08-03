package edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request;

import lombok.Data;

@Data
public class CrearProyectoRequest {
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
}
