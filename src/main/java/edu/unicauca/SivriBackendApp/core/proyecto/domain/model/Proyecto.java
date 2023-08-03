package edu.unicauca.SivriBackendApp.core.proyecto.domain.model;

import lombok.Data;

@Data
public class Proyecto {
    private int id;
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
}
