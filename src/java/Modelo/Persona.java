package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona implements Serializable{
    
    @Id
    @Column(name="idPersona")
    private int idPersona;
    
    @Column(name="Nombres")
    private String Nombres;
    
    @Column(name="Apellidos")
    private String Apellidos;
    
    @Column(name="Fecha_Nacimiento")
    private Date Fecha_Nacimiento;
    
    @Column(name="Telefono")
    private String Telefono;
    
    @Column(name="Genero")
    private String Genero;
    
    @Column(name="Correo")
    private String Correo;
    
    @Column(name="Contrasenia")
    private String Contrasenia;
    
    @Column(name="Avatar")
    private String Avatar;

    public Persona() {
    }

    public Persona(int idPersona, String Nombres, String Apellidos, Date Fecha_Nacimiento, String Telefono, String Genero, String Correo, String Contrasenia, String Avatar) {
        this.idPersona = idPersona;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Telefono = Telefono;
        this.Genero = Genero;
        this.Correo = Correo;
        this.Contrasenia = Contrasenia;
        this.Avatar = Avatar;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public Date getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Date Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }
    public String toString(){
    
        return String.valueOf(this.idPersona);
    
    }
    
}
