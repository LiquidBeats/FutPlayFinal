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

@Entity
@Table(name = "Encuentro")

public class Encuentros implements Serializable{

    @Id
    @Column(name = "idEncuentro")
    private int idEncuantro;
    
    @Column(name = "Tipo")
    private String Tipo;
    
    @Column(name = "Fecha_Hora")
    private Date Fecha_Hora;
    
    @Column(name = "Marcador")
    private String Marcador;
    
    @Column(name = "Estdo")
    private String Estado;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cancha")
    private Canchas Cancha;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Equipo_A")
    private Equipo Equipo_A;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Equipo_B")
    private Equipo Equipo_B;

    public Encuentros() {
    }

    public Encuentros(String Tipo, Date Fecha_Hora, String Marcador, String Estado, Canchas Cancha, Equipo Equipo_A, Equipo Equipo_B) {
        this.Tipo = Tipo;
        this.Fecha_Hora = Fecha_Hora;
        this.Marcador = Marcador;
        this.Estado = Estado;
        this.Cancha = Cancha;
        this.Equipo_A = Equipo_A;
        this.Equipo_B = Equipo_B;
    }

    public int getIdEncuantro() {
        return idEncuantro;
    }

    public void setIdEncuantro(int idEncuantro) {
        this.idEncuantro = idEncuantro;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public Date getFecha_Hora() {
        return Fecha_Hora;
    }

    public void setFecha_Hora(Date Fecha_Hora) {
        this.Fecha_Hora = Fecha_Hora;
    }

    public String getMarcador() {
        return Marcador;
    }

    public void setMarcador(String Marcador) {
        this.Marcador = Marcador;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Canchas getCancha() {
        return Cancha;
    }

    public void setCancha(Canchas Cancha) {
        this.Cancha = Cancha;
    }

    public Equipo getEquipo_A() {
        return Equipo_A;
    }

    public void setEquipo_A(Equipo Equipo_A) {
        this.Equipo_A = Equipo_A;
    }

    public Equipo getEquipo_B() {
        return Equipo_B;
    }

    public void setEquipo_B(Equipo Equipo_B) {
        this.Equipo_B = Equipo_B;
    }
    
    
}
