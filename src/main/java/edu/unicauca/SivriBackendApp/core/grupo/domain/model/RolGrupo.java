package edu.unicauca.SivriBackendApp.core.grupo.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RolGrupo {

    private Integer id;

    private String rolGrupo;
    public RolGrupo(int id) {
        this.id = id;
    }
}
