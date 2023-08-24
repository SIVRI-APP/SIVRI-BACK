package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "grupodisciplina")
public class Grupodisciplina {
    @Id
    @Column(name = "grupo_idGrupo")
    private Integer grupoIdGrupo;

    @Id
    @Column(name = "disciplina_idDisciplina")
    private Integer disciplinaIdDisciplina;

    public Integer getGrupoIdGrupo() {
        return this.grupoIdGrupo;
    }

    public void setGrupoIdGrupo(Integer grupoIdGrupo) {
        this.grupoIdGrupo = grupoIdGrupo;
    }

    public Integer getDisciplinaIdDisciplina() {
        return this.disciplinaIdDisciplina;
    }

    public void setDisciplinaIdDisciplina(Integer disciplinaIdDisciplina) {
        this.disciplinaIdDisciplina = disciplinaIdDisciplina;
    }
}
