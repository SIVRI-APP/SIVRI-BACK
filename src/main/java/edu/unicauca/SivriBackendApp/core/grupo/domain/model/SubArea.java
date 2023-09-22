package edu.unicauca.SivriBackendApp.core.grupo.domain.model;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.AreaEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubArea {
    private Integer idSubArea;
    private String subArea;

    private AreaEntity idArea;



}

