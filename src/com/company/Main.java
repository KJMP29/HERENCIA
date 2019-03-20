package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Maestro> maestros = new ArrayList<>();
    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Clase> clases = new ArrayList<>();

    static Scanner ent = new Scanner(System.in);

    public static void main(String[] args) {

        int op = 0;
        while (op != 5){
            System.out.println("--------Bienvenid(a) Registro de Matricula--------");
            System.out.println("|\t\t\t 1.- Clases                          |");
            System.out.println("|\t\t\t 2.- Maestros                        |");
            System.out.println("|\t\t\t 3.- Estudiantes                     |");
            System.out.println("|\t\t\t 4.- Informe                         |");
            System.out.println("|\t\t\t 5.- Salir                           |");
            System.out.println("--------------------------------------------------");

            System.out.println("Ingrese una opcion:");
            op = ent.nextInt();

            switch (op){

                case 1:

                    menuClase();

                    break;

                case 2:
                    menuMaestro();

                    break;
                case 3:
                    menuEstudiantes();

                    break;

                case 4:

                    informe();

                    break;




            }

        }


    }

    private static void informe() {
        System.out.println("------- INFORME --------");
        for(Clase c: clases){
            System.out.println("Clase  : " + c.getNombre() +" Horario: " + c.getHorario()+ "  Unidades Valorativas: "+ c.getUv());
            if(c.getMaestro() != null){
                System.out.println("Maestro: " + c.getMaestro().getNombre() + " " + c.getMaestro().getApellido());
            }else{
                System.out.println("Maestro: No Asignado");
            }
            for(Maestro asistente : c.getAsistente()){
                System.out.println("Asistente: " + asistente.getNombre() + " " + asistente.getApellido());
            }
            System.out.println("----------------------------------------------------");
            System.out.println("Estudiante\t\t\tNo.Ccuenta\t\t\tEs Oyente");
            int contEst = 0;
            int contAsi = 0;
            for(Estudiante est: c.getEstudiantes()){
                System.out.print(est.getNombre() + " " + est.getApellido() + "\t\t\t" + est.getNumCuenta() + "\t\t\t");
                if(est.EsOyente()){
                    System.out.println("Si");
                    contAsi++;
                }else
                {
                    System.out.println("No");
                    contEst++;
                }

            }
            System.out.println("---------------------------------------------------");
            System.out.println("Alumnos: " + contEst + "\t\tOyentes: " + contAsi + "\t\tAsistentes: " + c.getAsistente().size());
            System.out.println("");

        }
    }

    private static void menuEstudiantes() {

        int op = 0;

        while (op != 4){
            System.out.println("--------REGISTRO ESTUDIANTES--------");
            System.out.println("|       1.- Agregar Estudiante     |")   ;
            System.out.println("|       2.- Ver Estudiantes        |");
            System.out.println("|       3.- Matricular Clases      |");
            System.out.println("|       4.- Regresar               |");
            System.out.println("------------------------------------");

            System.out.println("Ingrese una opcion:");
            op = ent.nextInt();

            switch (op){

                case 1:

                    agregarEstudiante();
                    break;

                case 2:
                    verEstudiantes();
                    break;

                case 3:
                    matricularClase();
                    break;

            }

        }


    }

    private static void matricularClase() {
        System.out.println("------ESTUDIANTES------");
        for(Estudiante est:estudiantes){
            System.out.println("Nombre:" + est.getNombre()+" "+ est.getApellido()+"\t Numero Cuenta:"+ est.getNumCuenta());
        }

        System.out.println("Ingrese el numero de cuenta del estudiante:");
        int numC= ent.nextInt();
        Estudiante estu = null;
        for(Estudiante est:estudiantes){
            if(est.getNumCuenta()== numC){
                estu = est;
            }
        }

        if(estu == null){
            System.out.println("Estudiante no existe");
            return;
        }

        System.out.println("-------CLASES--------");

        for (Clase c:clases){
            System.out.println(" Nombre Clase:" + c.getNombre()+" Horario "+ c.getHorario()+" \t Unidades Valorativas:"+ c.getUv());
        }

        System.out.println("Ingrese el nombre de la clase a la cual le quiere agregar el estudiante:");
        String nomC;
        nomC = ent.next();

        Clase cm = null;
        for (Clase c:clases){
            if(c.getNombre().equalsIgnoreCase(nomC)){
                cm = c;
            }
        }
        if( cm == null){

            System.out.println("Clase no encontrada");
            return;
        }

        cm.getEstudiantes().add(estu);
    }

    private static void verEstudiantes() {

        for(Estudiante est:estudiantes){
            System.out.println("Nombre:" + est.getNombre()+" "+ est.getApellido()+"\t Numero Cuenta:"+ est.getNumCuenta());
        }
    }

    private static void agregarEstudiante() {

        Estudiante nuevoEst = new Estudiante();

        System.out.println("Ingrese el nombre estudiante: ");
        nuevoEst.setNombre(ent.next());
        System.out.println("Ingrese el apellido del estudiante");
        nuevoEst.setApellido(ent.next());
        System.out.println("Ingrese el numero de identidad del estudiante");
        nuevoEst.setIdentidad(ent.next());
        System.out.println("Ingrese el numero de cuenta del estudiante");
        nuevoEst.setNumCuenta(ent.nextInt());
        System.out.println(" Ingrese si es oyente (S/N):");
        nuevoEst.setEsOyente(ent.next().equalsIgnoreCase("S"));

        estudiantes.add(nuevoEst);


    }

    private static void menuClase() {
        int op = 0;

        while (op != 5){
            System.out.println("--------REGISTRO DE CLASES--------");
            System.out.println("|       1.- Agregar Clase        |");
            System.out.println("|       2.- Ver Clases           |");
            System.out.println("|       3.- Agregar Maestro      |");
            System.out.println("|       4.- Agregar Asistente    |");
            System.out.println("|       5.- Regresar             |");
            System.out.println("----------------------------------");


            System.out.println("Ingrese una opcion:");
            op = ent.nextInt();

            switch (op){

                case 1:

                    agregarClases();
                    break;

                case 2:
                    verClases();
                    break;

                case 3:
                    AgregarMaestroClase();
                    break;

                case 4:
                    AgregarAsistente();
            }

        }

    }

    private static void AgregarAsistente() {
        for (Clase c:clases){
            System.out.println(" Nombre Clase:" + c.getNombre()+" Horario "+ c.getHorario()+" \t Unidades Valorativas:"+ c.getUv());
        }
        System.out.println("Ingrese el nombre de la clase a la cual le quiere agregar el maestro:");
        String nomC;
        nomC = ent.next();

        Clase cm = null;
        for (Clase c:clases){
            if(c.getNombre().equalsIgnoreCase(nomC)){
                cm = c;
            }
        }
        if( cm == null){

            System.out.println("Clase no encontrada");
            return;
        }

        if(cm.getAsistente().size()>= 3){
            System.out.println("Esta clase ya tiene el limite de asistentes maximo");
            return;
        }

        for (Maestro mast:maestros){
            if(mast.EsAsistente()){
                System.out.println("Nombre:" + mast.getNombre()+" "+ mast.getApellido()+"\t Numero Empleado:"+ mast.getNumEmpleado());
            }
        }


        System.out.println("Ingrese el numero de empleado del asistente ha asignar :");
        int num = ent.nextInt();

        Maestro selec = null;
        for (Maestro mast:maestros) {

            if(mast.getNumEmpleado()== num && mast.EsAsistente()){
                selec = mast;
            }
        }
        if(selec== null){

            System.out.println("No se encontro el asistente");
            return;
        }

        cm.getAsistente().add(selec);

    }

    private static void AgregarMaestroClase() {
        for (Clase c:clases){
            System.out.println(" Nombre Clase:" + c.getNombre()+" Horario "+ c.getHorario()+" \t Unidades Valorativas:"+ c.getUv());
        }
        System.out.println("Ingrese el nombre de la clase a la cual le quiere agregar el maestro:");
        String nomC;
        nomC = ent.next();

        Clase cm = null;
        for (Clase c:clases){
            if(c.getNombre().equalsIgnoreCase(nomC)){
                cm = c;
            }
        }
        if( cm == null){

            System.out.println("Clase no encontrada");
            return;
        }

        if(cm.getMaestro() != null){
            System.out.println("Esta clase ya tiene un maestro asignado");
            return;
        }

        System.out.println("-------------MAESTROS DISPONIBLE-------------");
        for (Maestro mast:maestros) {
            if (mast.EsAsistente() == false) {
                System.out.println("Nombre:" + mast.getNombre() + " " + mast.getApellido() + "\t Numero Empleado:" + mast.getNumEmpleado());
            }
        }

        System.out.println("Ingrese el numero de empleado del maestro ha asignar :");
        int num = ent.nextInt();

        Maestro selec = null;
        for (Maestro mast:maestros) {

            if(mast.getNumEmpleado()== num){
                selec = mast;
            }
        }
        if(selec== null){

            System.out.println("No se encontro el maestro");
            return;
        }

        cm.setMaestro(selec);
    }

    private static void verClases() {


        for (Clase c:clases){
            System.out.println(" Nombre Clase :" + c.getNombre()+" Horario : "+ c.getHorario()+" Unidades Valorativas :"+ c.getUv());
        }
    }

    private static void agregarClases() {

        Clase nuevaC = new Clase();

        System.out.println(" Ingrese el nombre de la clase:");
        nuevaC.setNombre(ent.next());
        System.out.println(" Ingrese el horario:");
        nuevaC.setHorario(ent.next());
        System.out.println(" Ingrese las unidades valorativas:");
        nuevaC.setUv(ent.nextInt());

        clases.add(nuevaC);


    }

    private static void menuMaestro() {

        int op = 0;

        while (op != 3){
            System.out.println("--------REGISTRO MAESTROS---------");
            System.out.println("|      1.- Agregar Maestro       |");
            System.out.println("|      2.- Ver Maestros          |");
            System.out.println("|      3.- Regresar              |");
            System.out.println("----------------------------------");

            System.out.println("Ingrese una opcion:");
            op = ent.nextInt();

            switch (op){

                case 1:

                   agregarMaestro();
                    break;

                case 2:
                     verMaestros();
                    break;

            }

        }
    }

    private static void verMaestros() {

        for (Maestro mast:maestros){
            System.out.println("Nombre:" + mast.getNombre()+" "+ mast.getApellido()+"\t Numero Empleado:"+ mast.getNumEmpleado());
        }
    }

    private static void agregarMaestro() {

        Maestro nuevoM = new Maestro();

        System.out.println(" Ingrese el nombre del maestro:");
        nuevoM.setNombre(ent.next());
        System.out.println(" Ingrese el apellido del maestro:");
        nuevoM.setApellido(ent.next());
        System.out.println(" Ingrese numero de identidad del maestro:");
        nuevoM.setIdentidad(ent.next());
        System.out.println(" Ingrese numero de empleado del maestro:");
        nuevoM.setNumEmpleado(ent.nextInt());
        System.out.println(" Ingrese si es asistente (S/N):");
        nuevoM.setEsAsistente(ent.next().equalsIgnoreCase("S"));

        maestros.add(nuevoM);

    }


}
