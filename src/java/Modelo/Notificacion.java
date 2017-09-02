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
@Table(name = "Notificacion")
public class Notificacion implements Serializable{
    
    @Id
    @Column(name = "idNotificacion")
    private int idNotificacion;
    
    @Column(name = "Fecha")
    private Date Fecha;
    
    @Column(name = "Hora")
    private String Hora;
    
    @Column(name = "Tipo")
    private String Tipo;
    
    @Column(name = "Visto")
    private String Visto;
    
    @Column(name = "JugadorEnvia")
    private int JugadorEnvia;
    
    @Column(name = "JugadorRecibe")
    private int JugadorRecibe;
    
    @Column(name = "PropietarioEnvia")
    private int PropietarioEnvia;
    
    @Column(name = "PropietarioRecibe")
    private int PropietarioRecibe;
    
    @Column(name = "DatosAdicionales")
    private String DatosAdicionales;
    
    @Column(name = "EquipoEnvia")
    private int EquipoEnvia;
    
    @Column(name = "EquipoRecibe")
    private int EquipoRecibe;
    

    public Notificacion() {
    }

    public Notificacion(Date Fecha, String Hora, String Tipo, String Visto, int JugadorEnvia, int JugadorRecibe, int PropietarioEnvia, int PropietarioRecibe, String DatosAdicionales, int EquipoEnvia, int EquipoRecibe) {
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Tipo = Tipo;
        this.Visto = Visto;
        this.JugadorEnvia = JugadorEnvia;
        this.JugadorRecibe = JugadorRecibe;
        this.PropietarioEnvia = PropietarioEnvia;
        this.PropietarioRecibe = PropietarioRecibe;
        this.DatosAdicionales = DatosAdicionales;
        this.EquipoEnvia = EquipoEnvia;
        this.EquipoRecibe = EquipoRecibe;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getVisto() {
        return Visto;
    }

    public void setVisto(String Visto) {
        this.Visto = Visto;
    }

    public int getJugadorEnvia() {
        return JugadorEnvia;
    }

    public void setJugadorEnvia(int JugadorEnvia) {
        this.JugadorEnvia = JugadorEnvia;
    }

    public int getJugadorRecibe() {
        return JugadorRecibe;
    }

    public void setJugadorRecibe(int JugadorRecibe) {
        this.JugadorRecibe = JugadorRecibe;
    }

    public int getPropietarioEnvia() {
        return PropietarioEnvia;
    }

    public void setPropietarioEnvia(int PropietarioEnvia) {
        this.PropietarioEnvia = PropietarioEnvia;
    }

    public int getPropietarioRecibe() {
        return PropietarioRecibe;
    }

    public void setPropietarioRecibe(int PropietarioRecibe) {
        this.PropietarioRecibe = PropietarioRecibe;
    }

    public String getDatosAdicionales() {
        return DatosAdicionales;
    }

    public void setDatosAdicionales(String DatosAdicionales) {
        this.DatosAdicionales = DatosAdicionales;
    }

    public int getEquipoEnvia() {
        return EquipoEnvia;
    }

    public void setEquipoEnvia(int EquipoEnvia) {
        this.EquipoEnvia = EquipoEnvia;
    }

    public int getEquipoRecibe() {
        return EquipoRecibe;
    }

    public void setEquipoRecibe(int EquipoRecibe) {
        this.EquipoRecibe = EquipoRecibe;
    }

    

}
