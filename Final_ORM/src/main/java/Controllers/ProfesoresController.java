package Controllers;

import Tablas.Alumnos;
import Tablas.Profesores;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ProfesoresController implements MetodosTablas {
    Scanner teclado = new Scanner(System.in);

    @Override
    public void agregar() {

        String dni;
        int id;
        String salir;

        while (true) {

            System.out.println("añade el dni");
            dni = teclado.next();

            System.out.println("añade el ID del profesor");
            id = teclado.nextInt();

            //aqui agrego datos a la base vacia
            Configuration configuration = new Configuration();
            configuration.configure("hibernate2.cfg.xml");
            configuration.addAnnotatedClass(Profesores.class);

            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();

            Profesores profesores = new Profesores();
            profesores.setDNI(dni);
            profesores.setIdAlumno(id);

            session.beginTransaction();
            session.persist(profesores);
            session.getTransaction().commit();

            System.out.println("S - salir");
            salir = teclado.next();

            if (salir.equalsIgnoreCase("S")) {
                break;
            }
        }
    }

    @Override
    public void consultar() {
        int id;

        System.out.println("Introduce el ID de el profesor a consultar.");
        id = teclado.nextInt();
        System.out.println(obtenerId(id).toString());
    }

    @Override
    public void actualizar() {

    }

    @Override
    public void eliminar() {

    }


    public Profesores obtenerId(int id) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate2.cfg.xml");
        configuration.addAnnotatedClass(Profesores.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Profesores profesores = null;

        Transaction transaction = null;
        transaction = session.beginTransaction();

        profesores = session.get(Profesores.class, id);
        session.getTransaction().commit();
        return profesores;
    }
}