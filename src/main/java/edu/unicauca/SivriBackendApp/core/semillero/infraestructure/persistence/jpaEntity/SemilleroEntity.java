package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.ProgramaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.GrupoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "semillero")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//relacion de herencia
@PrimaryKeyJoinColumn(name = "semilleroId")
public class SemilleroEntity extends OrganismoDeInvestigacionEntity{
    @Column(nullable = false,length = 10)
    private String estado;

    @Column(length = 25)
    private String sede;

    //relacion 1a* con entidad semilleroDocumentacion
    @OneToMany(mappedBy = "idSemillero", fetch = FetchType.LAZY)
    private List<SemilleroDocumentacionEntity> documentosSemillero;

    //relacion *a* con entidad programa
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "semillero_programa",
            joinColumns = @JoinColumn(name="semilleroId"),
            inverseJoinColumns = @JoinColumn(name="idPrograma")
            )
    private List<ProgramaEntity> programas;

    //relacion 1a* con entidad lineadeInvestiacion
    @OneToMany(mappedBy = "idSemillero",fetch = FetchType.LAZY)
    private List<LineaInvestigacionEntity> lineasInvestigacion;

    //relacion de *a1 con entidad grupo
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "grupoId")
    private GrupoEntity idGrupo;


    //constructor para crear semillero
    public SemilleroEntity(Integer id, String nombre, LocalDate fechaCreacion, String estado, String objetivo,
                           String mision, String vision, String sede, GrupoEntity grupo) {
        super(id, nombre, fechaCreacion, objetivo, mision, vision);
        this.estado=estado;
        this.sede = sede;
        this.idGrupo = grupo;
    }


}
