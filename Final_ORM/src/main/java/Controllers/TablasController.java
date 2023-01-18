package Controllers;

import Tablas.Alumnos;
import Tablas.Asignaturas;
import Tablas.Personas;
import Tablas.Profesores;
import jakarta.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TablasController {

    public void menuOpciones() {

        System.out.println("""
                              
                ***OPCIONES***
                1.-AGREGAR.
                2.-CONSULTAR.
                3.-ACTUALIZAR.
                4.-ELIMINAR.
                """);
    }

    public void menuTablas() {
        System.out.println("""
               SELECCIONE LA TABLA.
                """);
        System.out.println("1.-" + nombreTablas(Personas.class));
        System.out.println("2.-" + nombreTablas(Alumnos.class));
        System.out.println("3.-" + nombreTablas(Profesores.class));
        System.out.println("4.-" + nombreTablas(Asignaturas.class));
    }

    //CREAR LAS TABLES VACAIS DE LA BASE DE DATOS
    public void crearTablas(Class x) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(x);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.getTransaction().commit();
    }

    //METODO PARA RECIBIR EL NOMBRE DE LAS TRABLAS Y DEVOLVER UN STRING.
    public String nombreTablas(Class y) {
        Table table = (Table) y.getAnnotation(Table.class);
        String tableName = table.name();
        //System.out.println(tableName);
        return tableName;
    }
}