package Tablas;

import jakarta.persistence.*;

@Entity
@Table(name = "Profesores")
public class Profesores {

    @Id
    @Column(name = "IdProfesores", length = 6)
    int IdProfesor;

    @Column(name = "DNI", length = 9)
    String DNI;

    //@OneToOne(mappedBy = "Profesores")
    //public Asignaturas asignaturas;

    //Getter and Setter
    public int getIdProfesor() {
        return IdProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        IdProfesor = idProfesor;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "***DATOS DEL PROFESOR***" +
                "\nDNI= " + DNI +
                "\nID Profesor= " + IdProfesor;
    }
}