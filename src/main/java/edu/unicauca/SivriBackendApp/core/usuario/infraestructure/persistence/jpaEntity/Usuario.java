package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "numeroDocumento")
    private String numeroDocumento;

    @Column(name = "tipoDocumento")
    private String tipoDocumento;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
