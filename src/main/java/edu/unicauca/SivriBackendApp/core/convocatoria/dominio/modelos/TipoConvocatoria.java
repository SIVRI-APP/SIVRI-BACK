package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciación;
import lombok.Data;


@Data
public class TipoConvocatoria {

    private Long id;

    private String nombre;

    private TipoFinanciación tipoFinanciación;

}

