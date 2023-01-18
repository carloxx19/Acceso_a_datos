package Tablas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Personas")
public class Personas {

    @Id
    @Column(name = "DNI", length = 9)
    private String DNI;

    @Column(name = "Nombre", length = 20)
    private String Nombre;

    @Column(name = "Apellido", length = 40)
    private String Apellido;

    @Column(name = "Ciudad", length = 20)
    private String Ciudad;

    //GETTER AND SETTER
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "***DATOS DE LA PERSONA*** " +
                "\nDNI= " + DNI +
                "\nNombre= " + Nombre +
                "\nApellido= " + Apellido +
                "\nCiudad= " + Ciudad;
    }
}