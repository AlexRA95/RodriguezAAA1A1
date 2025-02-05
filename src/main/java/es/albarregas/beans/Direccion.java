package es.albarregas.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "direcciones1a1A")
public class Direccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDirec")
    private int idDirec;

    @Column(name = "calle", length = 40, nullable = false)
    private String calle;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "poblacion", length = 30, nullable = false)
    private String poblacion;

    @Column(name = "provincia", length = 30, nullable = false)
    private String provincia;

    public int getIdDirec() {
        return idDirec;
    }

    public void setIdDirec(int idDirec) {
        this.idDirec = idDirec;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
