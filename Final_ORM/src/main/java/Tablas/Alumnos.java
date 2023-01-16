package Tablas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Alumnos")
public class Alumnos {

    @Id
    @Column(name = "IdAlumno", length = 6)
    int IdAlumno;

    @Column(name = "DNI", length = 9)
    String DNI;

    //Getter and Setter
    public int getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        IdAlumno = idAlumno;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "***DATOS DEL ALUMNO***" +
                "\nDNI= " + DNI +
                "\nID Alumno= " + IdAlumno;
    }
}