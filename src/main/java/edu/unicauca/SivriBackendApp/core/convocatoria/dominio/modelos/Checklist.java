package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos;

import lombok.Data;

@Data
public class Checklist {

    private Long id;

    private TipoFinanciacion tipoFinanciacion;

    private Documentacion documentacion;
}

