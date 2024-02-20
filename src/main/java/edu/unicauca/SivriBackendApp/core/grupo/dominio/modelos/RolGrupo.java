package edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos;

import lombok.Data;

@Data
public class RolGrupo {

    private Integer id;

    private String rolGrupo;
    public RolGrupo(int id) {
        this.id = id;
    }
}
