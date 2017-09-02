package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="Torneo")
public class Torneo implements Serializable{
    
    @Id
    @Column(name="idTorneo")
    private int idTorneo;
    
    @Column(name="Tipo")
    private String Tipo;
    
    @Column(name="Num_Equipos")
    private int Num_Equipos;
    
    @Column(name="Fecha_Inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha_Inicio;
    
    @Column(name="Fecha_Cierre")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha_Cierre;
    
    @Column(name="Modalidad")
    private String Modalidad;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Estadistica")
    private Estadistica Estadistica;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Propietario")
    private Propietario Propietario;

    public Torneo() {
    }

    public Torneo(int idTorneo, String Tipo, int Num_Equipos, Date Fecha_Inicio, Date Fecha_Cierre, String Modalidad, Estadistica Estadistica, Propietario Propietario) {
        this.idTorneo = idTorneo;
        this.Tipo = Tipo;
        this.Num_Equipos = Num_Equipos;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Cierre = Fecha_Cierre;
        this.Modalidad = Modalidad;
        this.Estadistica = Estadistica;
        this.Propietario = Propietario;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getNum_Equipos() {
        return Num_Equipos;
    }

    public void setNum_Equipos(int Num_Equipos) {
        this.Num_Equipos = Num_Equipos;
    }

    public Date getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(Date Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public Date getFecha_Cierre() {
        return Fecha_Cierre;
    }

    public void setFecha_Cierre(Date Fecha_Cierre) {
        this.Fecha_Cierre = Fecha_Cierre;
    }

    public String getModalidad() {
        return Modalidad;
    }

    public void setModalidad(String Modalidad) {
        this.Modalidad = Modalidad;
    }

    public Estadistica getEstadistica() {
        return Estadistica;
    }

    public void setEstadistica(Estadistica Estadistica) {
        this.Estadistica = Estadistica;
    }

    public Propietario getPropietario() {
        return Propietario;
    }

    public void setPropietario(Propietario Propietario) {
        this.Propietario = Propietario;
    }
    
    
}
