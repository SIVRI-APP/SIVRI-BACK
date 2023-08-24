package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "roladministrativo")
public class RolAdministrativo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
