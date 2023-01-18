package Controllers;

import Tablas.Alumnos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class AlumnosController implements MetodosTablas {
    Scanner teclado = new Scanner(System.in);

    @Override
    public void agregar() {

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

            if (salir.equalsIgnoreCase("S")) {
                break;
            }
        }
    }

    @Override
    public void consultar() {
        int id;

        System.out.println("Introduce el ID de el alumno a consultar.");
        id = teclado.nextInt();
        System.out.println(obtenerId(id).toString());
    }

    @Override
    public void actualizar() {
        int modificador;
        String modificadorString;

        Configuration configuration = new Configuration();
        configuration.configure("hibernate2.cfg.xml");
        configuration.addAnnotatedClass(Alumnos.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("introduce el ID del alumno a modificar");
        modificador = teclado.nextInt();
        Alumnos alumnos = session.getReference(Alumnos.class, modificador);

        System.out.println("Introduce nuevo DNI del alumno");
        modificadorString = teclado.next();
        alumnos.setDNI(modificadorString);

        session.merge(alumnos);
        transaction.commit();
        session.close();
    }

    @Override
    public void eliminar() {
        int modificador;

        Configuration configuration = new Configuration();
        configuration.configure("hibernate2.cfg.xml");
        configuration.addAnnotatedClass(Alumnos.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Introduce el id del alumno que quieres eliminar");
        modificador = teclado.nextInt();

        Alumnos alumnos = new Alumnos();
        alumnos.setIdAlumno(modificador);

        session.remove(alumnos);
        transaction.commit();
        session.close();
    }

    public Alumnos obtenerId(int id) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate2.cfg.xml");
        configuration.addAnnotatedClass(Alumnos.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Alumnos alumnos = null;

        Transaction transaction = null;
        transaction = session.beginTransaction();

        alumnos = session.get(Alumnos.class, id);
        session.getTransaction().commit();
        return alumnos;
    }
}