/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "Mensaje")
public class Mensaje implements Serializable{
    
    @Id
    @Column(name = "idMensaje")
    private int idMensaje;
    
    @Column(name = "Contenido")
    private String Contenido;
    
    @Column(name = "Fecha")
    private Date Fecha;
    
    @Column(name = "Hora")
    private String Hora;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Jugador")
    private Jugador Jugador;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Equipo")
    private Equipo Equipo;

    public Mensaje() {
    }

    public Mensaje(String Contenido, Date Fecha, String Hora, Jugador Jugador, Equipo Equipo) {
        this.Contenido = Contenido;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Jugador = Jugador;
        this.Equipo = Equipo;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
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

    public Jugador getJugador() {
        return Jugador;
    }

    public void setJugador(Jugador Jugador) {
        this.Jugador = Jugador;
    }

    public Equipo getEquipo() {
        return Equipo;
    }

    public void setEquipo(Equipo Equipo) {
        this.Equipo = Equipo;
    }
    
    
}
