package Controllers;

import Tablas.Profesores;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ProfesoresController implements MetodosTablas {
    @Override
    public void agregar() {
        Scanner teclado = new Scanner(System.in);
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
