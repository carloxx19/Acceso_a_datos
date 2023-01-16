package Tablas;

import jakarta.persistence.*;

@Entity
@Table(name = "Asignaturas")
public class Asignaturas {

    @Id
    @Column(name = "IdAsignatura", length = 6)
    int idAsignatura;

    @Column(name = "IdProfesor", length = 6)
    int IdProfesor;

    @Column(name = "Nombre", length = 20)
    String nombre;

    //@OneToOne
    //@JoinColumn(name = "IdProfesor")
    //public Profesores profesores;

    //GETTER AND SETTER
    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public int getIdProfesor() {
        return IdProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        IdProfesor = idProfesor;
    }

    @Override
    public String toString() {
        return "***DATOS DE LA ASIGNATURA***" +
                "\nID Asignatura= " + idAsignatura +
                "\nID Profesor= " + IdProfesor +
                "\nNombre asignatura= " + nombre;
    }
}