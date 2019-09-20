/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerParcial;

import java.security.SecureRandom;
 import java.util.Scanner;

/**
 *
 * @author Juan Carlos Rivera 
 */
public class Metodos {

    private double[][] lecturas;
    private double[] promedios;
    private double[] tempMinima;
    private double[] tempMaxima;
    private int horas;
    private int dias;
    private double promedioSemana;

    public Metodos(int horas, int dias) {
        promedios = new double[dias];
        tempMaxima = new double[dias];
        tempMinima = new double[dias];
        this.horas = horas;
        this.dias = dias;
        lecturas = new double[horas][dias];
        SecureRandom readLecturas = new SecureRandom();
        for (int filas = 0; filas < horas; filas++) {
            for (int columnas = 0; columnas < dias; columnas++) {

                lecturas[filas][columnas] = readLecturas.nextDouble() * 50;
            }
        }
        //Redondeo  los decimales 
        for (int filas = 0; filas < horas; filas++) {
            for (int columnas = 0; columnas < dias; columnas++) {

                lecturas[filas][columnas] = Math.round(lecturas[filas][columnas]*100) / 100;
            }
        }
    }

    public void leerLecturas() {
        System.out.println("L\tM\tMM\tJ\tV\tS\tD");
        System.out.println("===================================================");
        for (int filas = 0; filas < horas; filas++) {
            for (int columnas = 0; columnas < dias; columnas++) {
                System.out.print(lecturas[filas][columnas] + "\t");
            }
            System.out.println();

        }
        System.out.println();
        System.out.println("===================================================");

    }

    public void promSemana() {

        for (int i = 0; i < horas; i++) {
            for (int j = 0; j < dias; j++) {

                promedioSemana += lecturas[i][j];
            }
        }
        promedioSemana = promedioSemana / 7;
        System.out.printf("Promedio de la semana:%.2f ", promedioSemana);
        System.out.println("\n----------------------------------------------------\n");

    }

    public void promedios() {
        System.out.println("Promedio diario");
        System.out.println("L\tM\tMM\tJ\tV\tS\tD");
        System.out.println("===================================================");

        for (int fila = 0; fila < dias; fila++) {

            double suma = 0;

            for (int columna = 0; columna < horas; columna++) {

                suma = suma + lecturas[columna][fila];
            }
            promedios[fila] = Math.round(suma / horas * 100) / 100;

        }
        for (int filas = 0; filas < dias; filas++) {

            System.out.print(promedios[filas] + "\t");
        }
        System.out.println("\n----------------------------------------------------\n");

    }

    public void maximaDia() {
        System.out.println("Temperaturas Maximas por dia");
        System.out.println("L\tM\tMM\tJ\tV\tS\tD");
        System.out.println("===================================================");

        for (int fila = 0; fila < dias; fila++) {
            double aux = 0;

            for (int columna = 0; columna < horas; columna++) {
                if (lecturas[columna][fila] > aux) {
                    aux = lecturas[columna][fila];
                }

            }

            tempMaxima[fila] = aux;
        }
        for (int filas = 0; filas < dias; filas++) {

            System.out.print(tempMaxima[filas] + "\t");
        }
        System.out.println("\n----------------------------------------------------\n\n");

    }

    public void minimaDia() {
        System.out.println("Temperaturas Minima por dia");
        System.out.println("L\tM\tMM\tJ\tV\tS\tD");
        System.out.println("===================================================");

        for (int fila = 0; fila < dias; fila++) {
            double aux = lecturas[0][fila];

            for (int columna = 0; columna < horas; columna++) {

                if (lecturas[columna][fila] < aux) {
                    aux = lecturas[columna][fila];
                }

            }

            tempMinima[fila] = aux;
        }

        for (int filas = 0; filas < dias; filas++) {

            System.out.print(tempMinima[filas] + "\t");
        }
        System.out.println("\n----------------------------------------------------\n\n");


    }

    public void menu() {
        System.out.println("**** C E N T R O   M E T E R E O L O G I C O *****");
        System.out.println("Primer parcial - Programacion");
        System.out.println("Universidad: C E S B A\n");
        System.out.println("====================================================================\n");

        Scanner entradaDatos = new Scanner(System.in);
        int opc = 0;

        System.out.println("1.- Mostrar lectutas\t\t2.- Cargar Temperatura Maxima Diaria ");
        System.out.println("3.- Cargar promedio Diario\t4.- Cargar Temperatura Minima Diaria ");
        System.out.println("5.- Cargar promedio semanal \t6.- cargar todos los datos");
        System.out.println("7.- Salir");
        System.out.println("-----------------------------------------------------------------------");

        do {
            System.out.print("Digita la opcion:");
            opc = entradaDatos.nextInt();
            switch (opc) {
                case 1:
                    leerLecturas();
                    break;
                case 2:
                    maximaDia();
                    break;
                case 3:
                    promedios();
                    break;
                case 4:
                    minimaDia();
                    break;
                case 5:
                    promSemana();
                    break;
                case 6: ;
                    leerLecturas();
                    maximaDia();
                    minimaDia();
                    promedios();
                    promSemana();
                    break;
              

            }
        } while (opc != 7);
    }

}
