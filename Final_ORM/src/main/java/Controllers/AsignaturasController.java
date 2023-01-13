package Controllers;

import Tablas.Alumnos;
import Tablas.Asignaturas;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AsignaturasController implements MetodosTablas {

    @Override
    public void agregar() {
        Scanner teclado = new Scanner(System.in);

        int idAsignatura;
        int idProfesor;
        String nombre;
        String salir;

        while (true) {

            System.out.println("añade el ID del Profesor.");
            idProfesor = teclado.nextInt();

            System.out.println("añade el ID de la Asignatura");
            idAsignatura = teclado.nextInt();

            System.out.println("añade el nombre de la Asignatura");
            nombre = teclado.next();

            //aqui agrego datos a la base vacia
            Configuration configuration = new Configuration();
            configuration.configure("hibernate2.cfg.xml");
            configuration.addAnnotatedClass(Asignaturas.class);

            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();

            Asignaturas asignaturas = new Asignaturas();
            asignaturas.setIdProfesor(idProfesor);
            asignaturas.setIdAsignatura(idAsignatura);
            asignaturas.setNombre(nombre);


            session.beginTransaction();
            session.persist(asignaturas);
            session.getTransaction().commit();

            System.out.println("S - salir");
            salir = teclado.next();

            if (salir.equalsIgnoreCase("S")){
                break;
            }
        }
    }

    @Override
    public void leer() {

    }

    @Override
    public void actualizar() {

    }

    @Override
    public void consultar() {

    }
}
