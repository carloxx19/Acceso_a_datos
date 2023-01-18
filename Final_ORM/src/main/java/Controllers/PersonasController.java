package Controllers;

import Tablas.Personas;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class PersonasController implements InterfacePersonas {
    Scanner teclado = new Scanner(System.in);

    @Override
    public void agregar() {

        String dni;
        String nombre;
        String apellido;
        String ciudad;
        String salir;

        while (true) {

            System.out.println("añade el dni");
            dni = teclado.next();

            System.out.println("añade el nombre");
            nombre = teclado.next();

            System.out.println("añade el apellido");
            apellido = teclado.next();

            System.out.println("añade la ciudada");
            ciudad = teclado.next();

            //aqui agrego datos a la base vacia
            Configuration configuration = new Configuration();
            configuration.configure("hibernate2.cfg.xml");
            configuration.addAnnotatedClass(Personas.class);

            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();

            Personas p = new Personas();
            p.setDNI(dni);
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setCiudad(ciudad);

            session.beginTransaction();
            session.persist(p);
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
        String dni;

        System.out.println("Introduce el DNI de la persona a consultar.");
        dni = teclado.next();
        System.out.println(obtenerdni(dni).toString());
    }

    @Override
    public void actualizar() {
        String modificador;

        Configuration configuration = new Configuration();
        configuration.configure("hibernate2.cfg.xml");
        configuration.addAnnotatedClass(Personas.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("introduce el DNI de la persona a midificar");
        modificador = teclado.next();
        Personas personas = session.getReference(Personas.class, modificador);

        System.out.println("Introduce el Nombre");
        modificador = teclado.next();
        personas.setNombre(modificador);

        System.out.println("Introduce el Apellido");
        modificador = teclado.next();
        personas.setApellido(modificador);

        System.out.println("Introduce la ciudad");
        modificador = teclado.next();
        personas.setCiudad(modificador);

        session.merge(personas);
        transaction.commit();
        session.close();
    }

    @Override
    public void eliminar() {

    }

    @Override
    public Personas obtenerdni(String dni) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate2.cfg.xml");
        configuration.addAnnotatedClass(Personas.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Personas personas = null;

        Transaction transaction = null;
        transaction = session.beginTransaction();

        personas = session.get(Personas.class, dni);
        session.getTransaction().commit();
        return personas;
    }
}