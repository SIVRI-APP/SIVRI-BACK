package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;


import com.fasterxml.jackson.annotation.*;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.ProgramaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.GrupoEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.PlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.SemilleroEstado;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "semillero")
@Data
//relacion de herencia
@PrimaryKeyJoinColumn(name = "semilleroId")
public class SemilleroEntity extends OrganismoDeInvestigacionEntity{

    @Column(nullable = false,length = 10)
    @Enumerated(EnumType.STRING)
    private SemilleroEstado estado;

    @Column(length = 25)
    private String sede;

    //relacion ce 1a* con integranteSemillero

    //@JsonBackReference
    //@JsonIgnore
    /*@OneToMany(mappedBy = "semillero",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<IntegranteSemilleroEntity> integrantes;
    *///relacion 1a* con entidad semilleroDocumentacion
    @OneToMany(mappedBy = "semillero", fetch = FetchType.LAZY)
    private List<SemilleroDocumentacionEntity> documentosSemillero;

    //relacion 1a* con entidad lineadeInvestiacion
    @OneToMany(mappedBy = "semillero",fetch = FetchType.LAZY)
    private List<LineaInvestigacionEntity> lineasInvestigacion;

    //relacion de *a1 con entidad grupo
    //@PrimaryKeyJoinColumn(name = "grupoId")

    @JsonManagedReference
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "grupoId")
    private GrupoEntity grupo;

    //relacion de 1a* con plan de trabajo
    /*@JsonBackReference
    @OneToMany(mappedBy = "semillero",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<PlanTrabajoEntity> planesTrabajo;
*/

    @Override
    public String toString() {
        return "SemilleroEntity{" +
                "estado=" + estado +
                ", sede='" + sede + '\'' +
                ", grupo=" + grupo +
                '}';
    }
}
