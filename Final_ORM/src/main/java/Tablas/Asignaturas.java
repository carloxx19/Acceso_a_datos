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
    String Nombre;

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

    public int getIdProfesor() {
        return IdProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        IdProfesor = idProfesor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return "***DATOS DE LA ASIGNATURA***" +
                "\nID Asignatura= " + idAsignatura +
                "\nID Profesor= " + IdProfesor +
                "\nNombre asignatura= " + Nombre;
    }
}