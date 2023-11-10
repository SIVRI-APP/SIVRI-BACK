package edu.unicauca.SivriBackendApp.core.grupo.domain.model;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.AreaEntity;

import lombok.*;

@Data
public class SubArea {
    private Integer idSubArea;
    private String subArea;

    private Area idArea;



}

