package Tablas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Asignaturas")
public class Asignaturas {

    @Id
    @Column(name = "IdAsignatura", length = 6)
    int idAsignatura;

    @Column(name = "Nombre", length = 20)
    String Nombre;

    @Column(name = "IdProfesor", length = 6)
    int IdProfesor;

    //GETTER AND SETTER
    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getIdProfesor() {
        return IdProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        IdProfesor = idProfesor;
    }
}