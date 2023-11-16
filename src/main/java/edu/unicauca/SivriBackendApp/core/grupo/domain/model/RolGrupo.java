package edu.unicauca.SivriBackendApp.core.grupo.domain.model;

import lombok.*;

@Data
public class RolGrupo {

    private Integer id;

    private String rolGrupo;
    public RolGrupo(int id) {
        this.id = id;
    }
}
