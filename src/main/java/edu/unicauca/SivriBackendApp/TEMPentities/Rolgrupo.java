package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "rolgrupo")
public class Rolgrupo {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "rolGrupo")
    private String rolGrupo;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolGrupo() {
        return this.rolGrupo;
    }

    public void setRolGrupo(String rolGrupo) {
        this.rolGrupo = rolGrupo;
    }
}
