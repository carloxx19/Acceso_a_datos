package Controllers;

import Tablas.Alumnos;
import Tablas.Asignaturas;
import Tablas.Profesores;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AsignaturasController implements MetodosTablas {
    Scanner teclado = new Scanner(System.in);

    @Override
    public void agregar() {

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

            if (salir.equalsIgnoreCase("S")) {
                break;
            }
        }
    }

    @Override
    public void consultar() {
        int id;

        System.out.println("Introduce el ID de la asignatura.");
        id = teclado.nextInt();
        System.out.println(obtenerId(id).toString());
    }

    public Asignaturas obtenerId(int id) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate2.cfg.xml");
        configuration.addAnnotatedClass(Asignaturas.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Asignaturas asignaturas = null;

        Transaction transaction = null;
        transaction = session.beginTransaction();

        asignaturas = session.get(Asignaturas.class, id);
        session.getTransaction().commit();
        return asignaturas;
    }

    @Override
    public void actualizar() {
        int modificador;
        String modificadorString;

        Configuration configuration = new Configuration();
        configuration.configure("hibernate2.cfg.xml");
        configuration.addAnnotatedClass(Asignaturas.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("introduce el ID de la asignatura a modificar");
        modificador = teclado.nextInt();
        Asignaturas asignaturas = session.getReference(Asignaturas.class, modificador);

        System.out.println("introduce el ID del profesor a modificar");
        modificador = teclado.nextInt();
        asignaturas.setIdProfesor(modificador);

        System.out.println("introduce el nombre de la asignatura a modificar");
        modificadorString = teclado.next();
        asignaturas.setNombre(modificadorString);

        session.merge(asignaturas);
        transaction.commit();
        session.close();
    }

    @Override
    public void eliminar() {
        int modificador;

        Configuration configuration = new Configuration();
        configuration.configure("hibernate2.cfg.xml");
        configuration.addAnnotatedClass(Asignaturas.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Introduce el id de la asignatura que quieres eliminar");
        modificador = teclado.nextInt();

        Asignaturas asignaturas = new Asignaturas();
        asignaturas.setIdAsignatura(modificador);

        session.remove(asignaturas);
        transaction.commit();
        session.close();
    }
}