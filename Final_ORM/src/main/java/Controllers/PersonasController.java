package Controllers;

import Tablas.Personas;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class PersonasController implements MetodosTablas {

    @Override
    public void agregar() {
        Scanner teclado = new Scanner(System.in);
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
    public void leer() {

    }

    @Override
    public void actualizar() {

    }

    @Override
    public void consultar() {

    }
}