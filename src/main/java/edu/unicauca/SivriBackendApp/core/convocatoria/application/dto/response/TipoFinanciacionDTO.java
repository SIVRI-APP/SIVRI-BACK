package edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.response;

import lombok.Data;

import java.util.List;


@Data
public class TipoFinanciacionDTO {

    private Long id;

    private String tipo;

    private List<ChecklistDTO> checklist;

}

