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
                    System.out.println("***AGREGAR***");
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
                    } else {
                        System.out.println("opcion introducida no valida");
                    }
                }
                case 2 -> {
                    //CASE 2-> CONSULTAR POR ID.
                    System.out.println("***CONSULTAR***");
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
                    } else {
                        System.out.println("opcion introducida no valida");
                    }
                }
                case 3 -> {
                    //CASE 3-> ACTUALIZAR POR ID
                    System.out.println("***ACTUALIZAR***");
                    tablasController.menuTablas();
                    opcionTabla = teclado.nextInt();

                    if (opcionTabla == 1) {
                        PersonasController personasController = new PersonasController();
                        personasController.actualizar();
                    } else if (opcionTabla == 2) {
                        AlumnosController alumnosController = new AlumnosController();
                        alumnosController.actualizar();
                    } else if ((opcionTabla == 3)) {
                        ProfesoresController profesoresController = new ProfesoresController();
                        profesoresController.actualizar();
                    } else if (opcionTabla == 4) {
                        AsignaturasController asignaturasController = new AsignaturasController();
                        asignaturasController.actualizar();
                    } else {
                        System.out.println("opcion introducida no valida");
                    }
                }
                case 4 -> {
                    System.out.println("***ELIMINAR***");
                    tablasController.menuTablas();
                    opcionTabla = teclado.nextInt();

                    if (opcionTabla == 1) {
                        PersonasController personasController = new PersonasController();
                        personasController.eliminar();
                    } else if (opcionTabla == 2) {
                        AlumnosController alumnosController = new AlumnosController();
                        alumnosController.eliminar();
                    } else if ((opcionTabla == 3)) {
                        ProfesoresController profesoresController = new ProfesoresController();
                        profesoresController.eliminar();
                    } else if (opcionTabla == 4) {
                        AsignaturasController asignaturasController = new AsignaturasController();
                        asignaturasController.eliminar();
                    } else {
                        System.out.println("opcion introducida no valida");
                    }
                }
            }
        }
    }
}