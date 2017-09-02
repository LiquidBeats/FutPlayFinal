package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Campo")
public class Campos implements Serializable{
    
    @Id
    @Column(name = "idCampo")
    private int idCampo;
    
    @Column(name = "Nombre")
    private String Nombre;
    
    @Column(name = "Direccion")
    private String Direccion;
    
    @Column(name = "Ubicacion")
    private String Ubicacion;
    
    @Column(name = "Horario")
    private String Horario;
    
    @Column(name = "Rating")
    private int Rating;
    
    @Column(name = "Foto")
    private String Foto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Propietario")
    private Propietario Propietario;

    public Campos() {
    }

    public Campos(int idCampo, String Nombre, String Direccion, String Ubicacion, String Horario, int Rating, String Foto, Propietario Propietario) {
        this.idCampo = idCampo;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Ubicacion = Ubicacion;
        this.Horario = Horario;
        this.Rating = Rating;
        this.Foto = Foto;
        this.Propietario = Propietario;
    }

    
    public int getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(int idCampo) {
        this.idCampo = idCampo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public Propietario getPropietario() {
        return Propietario;
    }

    public void setPropietario(Propietario Propietario) {
        this.Propietario = Propietario;
    }
    
    
    
    
}
