package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "credenciales")
public class Credenciales {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "contraseña")
    private String contraseña;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
