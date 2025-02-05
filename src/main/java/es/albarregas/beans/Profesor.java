package es.albarregas.beans;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "profesores1a1A")
public class Profesor {
    @Id
    @GeneratedValue(generator = "generador")
    @GenericGenerator(name = "generador", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "direccion"))
    @Column(name = "idProf")
    private Integer id;

    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;

    @Column(name = "ape1", length = 15, nullable = false)
    private String ape1;

    @Column(name = "ape2", length = 15, nullable = true)
    private String ape2;

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private Direccion direccion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}