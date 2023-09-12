package edu.unicauca.SivriBackendApp.core.convocatoria.domain.model;

import lombok.Data;

import java.util.List;


@Data
public class TipoFinanciacion {

    private Long id;

    private String tipo;

    private List<Checklist> checklist;

    private List<Convocatoria> convocatorias;
}

