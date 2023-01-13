package Controllers;

import Tablas.Alumnos;
import Tablas.Personas;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AlumnosController implements MetodosTablas {

    @Override
    public void agregar() {
        Scanner teclado = new Scanner(System.in);
        String dni;
        int id;
        String salir;

        while (true) {

            System.out.println("añade el dni");
            dni = teclado.next();

            System.out.println("añade el ID del alumno");
            id = teclado.nextInt();


            //aqui agrego datos a la base vacia
            Configuration configuration = new Configuration();
            configuration.configure("hibernate2.cfg.xml");
            configuration.addAnnotatedClass(Alumnos.class);

            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();

            Alumnos alumnos = new Alumnos();
            alumnos.setDNI(dni);
            alumnos.setIdAlumno(id);


            session.beginTransaction();
            session.persist(alumnos);
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
