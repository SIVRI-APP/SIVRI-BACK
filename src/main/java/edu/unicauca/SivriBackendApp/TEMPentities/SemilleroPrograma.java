package edu.unicauca.SivriBackendApp.TEMPentities;

import jakarta.persistence.*;

@Entity
@Table(name = "semillero_programa")
public class SemilleroPrograma {
    @Id
    @Column(name = "semillero_idSemillero")
    private Integer semilleroIdSemillero;

    @Id
    @Column(name = "programa_idPrograma")
    private Integer programaIdPrograma;

    public Integer getSemilleroIdSemillero() {
        return this.semilleroIdSemillero;
    }

    public void setSemilleroIdSemillero(Integer semilleroIdSemillero) {
        this.semilleroIdSemillero = semilleroIdSemillero;
    }

    public Integer getProgramaIdPrograma() {
        return this.programaIdPrograma;
    }

    public void setProgramaIdPrograma(Integer programaIdPrograma) {
        this.programaIdPrograma = programaIdPrograma;
    }
}
