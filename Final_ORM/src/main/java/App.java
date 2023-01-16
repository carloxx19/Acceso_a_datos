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
        tablasController.crearTablas(Asignaturas.class);
        tablasController.crearTablas(Profesores.class);


        while (true) {
            //MOSTRAMOS EL MENU DE LA OPCION QUE QUEREMOS REALIZAR
            tablasController.menuOpciones();
            opcionMenu = teclado.nextInt();

            switch (opcionMenu) {
                case 1 -> {
                    //CASE 1 -> AGREGAR
                    //MUESTRA EL MENU,  Y SELEECIONAMOS LA TABLA EN LA QUE QUEREMOS AGREGAR
                    tablasController.menuTablas();
                    opcionTabla = teclado.nextInt();
                    if (opcionTabla == 1) {
                        //AGREGAR TABLA PERSONAS.
                        PersonasController personasController = new PersonasController();
                        personasController.agregar();
                    } else if (opcionTabla == 2) {
                        //AGREGAR TABLA ALUMNOS
                        AlumnosController alumnosController = new AlumnosController();
                        alumnosController.agregar();
                    } else if (opcionTabla == 3) {
                        //AGREGAR TABLA PROFESORES
                        ProfesoresController profesoresController = new ProfesoresController();
                        profesoresController.agregar();
                    } else if (opcionTabla == 4) {
                        //AGREGAR TABLA ASIGNATURAS
                        AsignaturasController asignaturasController = new AsignaturasController();
                        asignaturasController.agregar();
                    }
                }
                case 2 -> {
                    //CASE 2-> CONSULTAR POR ID.
                    tablasController.menuTablas();
                    opcionTabla = teclado.nextInt();
                    if (opcionTabla == 1) {
                        PersonasController personasController = new PersonasController();
                        personasController.consultar();
                    } else if (opcionTabla == 2) {
                        AlumnosController alumnosController = new AlumnosController();
                        alumnosController.consultar();
                    } else if (opcionTabla == 3) {
                        ProfesoresController profesoresController = new ProfesoresController();
                        profesoresController.consultar();
                    } else if (opcionTabla == 4) {
                        AsignaturasController asignaturasController = new AsignaturasController();
                        asignaturasController.consultar();
                    }
                }
                case 3 -> {
                    //CASE 3-> ACTUALIZAR POR ID
                    tablasController.menuTablas();
                    opcionTabla = teclado.nextInt();

                    if (opcionTabla == 1) {

                    }

                    PersonasController personasController = new PersonasController();
                    personasController.actualizar();
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