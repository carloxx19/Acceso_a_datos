import Controllers.*;
import Tablas.Alumnos;
import Tablas.Asignaturas;
import Tablas.Personas;
import Tablas.Profesores;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        //VARIABLES DE ENTRADA DE TECLADO Y PARA ENTRAR EN EL MENU POR INT
        Scanner teclado = new Scanner(System.in);
        int opcionMenu;
        int opcionTabla;

        //OBJETO Controllers.TablasController Y CREAMOS LAS TABLAS.
        TablasController tablasController = new TablasController();
        tablasController.crearTablas(Personas.class);
        tablasController.crearTablas(Alumnos.class);
        tablasController.crearTablas(Profesores.class);
        tablasController.crearTablas(Asignaturas.class);

        while (true) {
            //MOSTRAMOS EL MENU DE LA OPCION QUE QUEREMOS REALIZAR
            tablasController.menuOpciones();
            opcionMenu = teclado.nextInt();

            switch (opcionMenu) {
                case 1 -> {
                    //MUESTRA EL MENU AGREGAR Y SELEECIONAMOS LA TABLA EN LA QUE QUEREMOS AGREGAR
                    tablasController.menuTablas();
                    opcionTabla = teclado.nextInt();
                    if (opcionTabla == 1) {
                        //TABLA PERSONAS.
                        PersonasController ps = new PersonasController();
                        ps.agregar();
                    } else if (opcionTabla == 2) {
                        AlumnosController alumnosController = new AlumnosController();
                        alumnosController.agregar();
                    } else if (opcionTabla == 3) {
                        ProfesoresController profesoresController = new ProfesoresController();
                        profesoresController.agregar();
                    } else if (opcionTabla == 4) {
                        AsignaturasController asignaturasController = new AsignaturasController();
                        asignaturasController.agregar();
                    }
                }
            }
            //PersonasController personasController = new PersonasController();
            // personasController.agregar();

            //aqui add datos a la base vacia
       /* session.beginTransaction();
        Personas p = new Personas();
        p.setDNI("qq");
        session.persist(p);
        session.getTransaction().commit();

        */
        }
    }
}