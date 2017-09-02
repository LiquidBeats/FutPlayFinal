package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Equipo")
public class Equipo implements Serializable{
    
    @Id
    @Column(name="idEquipo")
    /////////////////// TENER EN CUENTA QUE EL VALOR DEL IDEQUIPO SEA IGUAL A 1 //////////////////////////////////////////
    private int idEquipo;
    
    @Column(name="Nombre")
    private String Nombre;
    
    @Column(name="Ciudad")
    private String Ciudad;
    
    /////////////////// SE CAMBIO EL CAMPO CAPITAN POR LA RELACION LLAMADA JUGADOR/////////////////////
    @Column(name = "Capitan")
    private int Capitan;

    public Equipo() {
    }

    public Equipo(int idEquipo, String Nombre, String Ciudad, int Capitan) {
        this.idEquipo = idEquipo;
        this.Nombre = Nombre;
        this.Ciudad = Ciudad;
        this.Capitan = Capitan;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public int getCapitan() {
        return Capitan;
    }

    public void setidCapitan(int Capitan) {
        this.Capitan = Capitan;
    }
    public String toString(){
    
        return String.valueOf(this.idEquipo);
    
    } 
}
