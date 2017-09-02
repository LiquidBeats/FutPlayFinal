package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Estadistica")
public class Estadistica implements Serializable{
    
    @Id
    @Column(name="idEstadistica")
    private int idEstadistica;
    
    @Column(name="Campeon")
    private int Campeon;
    
    @Column(name="Goleador")
    private int Goleador;

    public Estadistica() {
    }

    public Estadistica(int idEstadistica, int Campeon, int Goleador) {
        this.idEstadistica = idEstadistica;
        this.Campeon = Campeon;
        this.Goleador = Goleador;
    }

    public int getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(int idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    public int getCampeon() {
        return Campeon;
    }

    public void setCampeon(int Campeon) {
        this.Campeon = Campeon;
    }

    public int getGoleador() {
        return Goleador;
    }

    public void setGoleador(int Goleador) {
        this.Goleador = Goleador;
    }  
    
}
