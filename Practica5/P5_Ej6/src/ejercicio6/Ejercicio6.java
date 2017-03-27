/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Universidad uni = new Universidad("Uvigo", 3);

        try {
            uni.insertar(leerAlumno());
            uni.insertar(leerProfesor());
        } catch (DemasiadasPersonasException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println(uni.toString());
    }

    public static Alumno leerAlumno() {
        Scanner entrada = new Scanner(System.in);
        String DNI;
        String planEstudios;
        DNI = readDNI(entrada);
        System.out.println("Introduce plan de estudios");
        planEstudios = entrada.nextLine();

        return new Alumno(DNI, planEstudios);
    }

    private static String readDNI(Scanner entrada) {
        String DNI;
        System.out.println("Introduce DNI");
        DNI = entrada.nextLine();
        return DNI;
    }

    public static Profesor leerProfesor() {
        Scanner entrada = new Scanner(System.in);
        String DNI;
        int despacho;
        String asignatura;
        try {
            DNI = readDNI(entrada);
            System.out.println("Introduce despacho");
            despacho = Integer.parseInt(entrada.nextLine());
            System.out.println("Introduce asignatura");
            asignatura = entrada.nextLine();
            return new Profesor(DNI, despacho, asignatura);
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
