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
@Table(name="Jugador")
public class Jugador implements Serializable{
    
    @Id
    @Column(name="idJugador")
    private int idJugador;
    
    @Column(name="Alias")
    private String Alias;
    
    @Column(name="Posicion")
    private String Posicion;
    
    @Column(name="Pierna")
    private String Pierna;
    
    @Column(name="Descripcion")
    private String Descripcion;
    
    @Column(name="RankingSystem")
    private Double RankingSystem;
    
    @Column(name="RankingUsers")
    private String RankingUsers;
    
    @Column(name="Estado")
    private String Estado;
    
    @Column(name="Capitan")
    private Boolean Capitan;
    ////////////////////////////////////////////// SE CAMBIO A EAGER LA RELACION POR CAUSA DE ERRORES/////////////////////
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Equipo")
    private Equipo Equipo;
    
////////////////////////////////////////////// SE CAMBIO A EAGER LA RELACION POR CAUSA DE ERRORES/////////////////////

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Persona")
    private Persona Persona;

    public Jugador() {
    }

    public Jugador(int idJugador, String Alias, String Posicion, String Pierna, String Descripcion, Double RankingSystem, String RankingUsers, String Estado, Boolean Capitan, Equipo Equipo, Persona Persona) {
        this.idJugador = idJugador;
        this.Alias = Alias;
        this.Posicion = Posicion;
        this.Pierna = Pierna;
        this.Descripcion = Descripcion;
        this.RankingSystem = RankingSystem;
        this.RankingUsers = RankingUsers;
        this.Estado = Estado;
        this.Capitan = Capitan;
        this.Equipo = Equipo;
        this.Persona = Persona;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String Alias) {
        this.Alias = Alias;
    }

    public String getPosicion() {
        return Posicion;
    }

    public void setPosicion(String Posicion) {
        this.Posicion = Posicion;
    }

    public String getPierna() {
        return Pierna;
    }

    public void setPierna(String Pierna) {
        this.Pierna = Pierna;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Double getRankingSystem() {
        return RankingSystem;
    }

    public void setRankingSystem(Double RankingSystem) {
        this.RankingSystem = RankingSystem;
    }

    public String getRankingUsers() {
        return RankingUsers;
    }

    public void setRankingUsers(String RankingUsers) {
        this.RankingUsers = RankingUsers;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Boolean getCapitan() {
        return Capitan;
    }

    public void setCapitan(Boolean Capitan) {
        this.Capitan = Capitan;
    }

    public Equipo getEquipo() {
        return Equipo;
    }

    public void setEquipo(Equipo Equipo) {
        this.Equipo = Equipo;
    }

    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }
    public String toString(){
    
        return String.valueOf(this.idJugador);
    
    }
    
}
