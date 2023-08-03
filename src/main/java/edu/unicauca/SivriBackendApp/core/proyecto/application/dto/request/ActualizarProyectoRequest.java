package edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request;

import lombok.Data;

@Data
public class ActualizarProyectoRequest {
    private int id;
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
}
