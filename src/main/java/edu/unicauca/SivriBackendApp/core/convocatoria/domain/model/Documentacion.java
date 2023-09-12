package edu.unicauca.SivriBackendApp.core.convocatoria.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Documentacion {

    private Long id;

    private String nombre;

    private List<Checklist> checklist;
}
