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
@Table(name = "Cancha")
public class Canchas implements Serializable{

    @Id
    @Column(name = "idCancha")
    private int idCancha;
    
    @Column(name = "Numero")
    private int Numero;
    
    @Column(name = "tipo_Cancha")
    private String Tipo_Cancha;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Campo")
    private Campos Campo;

    public Canchas() {
    }

    public Canchas(int Numero, String Tipo_Cancha , Campos Campo) {
        this.Numero = Numero;
        this.Tipo_Cancha = Tipo_Cancha;
        this.Campo = Campo;
    }

    public int getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(int idCancha) {
        this.idCancha = idCancha;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getTipo_Cancha() {
        return Tipo_Cancha;
    }

    public void setTipo_Cancha(String Tipo_Cancha) {
        this.Tipo_Cancha = Tipo_Cancha;
    }

    public Campos getCampo() {
        return Campo;
    }

    public void setCampo(Campos Campo) {
        this.Campo = Campo;
    }
    
    
}
