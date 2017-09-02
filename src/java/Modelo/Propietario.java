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
@Table(name="Propietario")
public class Propietario implements Serializable{
    
    @Id
    @Column(name="idPropietario")
    private int idPropietario;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Persona")
    private Persona Persona;

    public Propietario() {
    }

    public Propietario(int idPropietario, Persona Persona) {
        this.idPropietario = idPropietario;
        this.Persona = Persona;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }
    
    
    
}
