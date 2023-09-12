package edu.unicauca.SivriBackendApp.core.convocatoria.domain.model;

import lombok.Data;

@Data
public class Checklist {

    private Long id;

    private TipoFinanciacion tipoFinanciacion;

    private Documentacion documentacion;
}

