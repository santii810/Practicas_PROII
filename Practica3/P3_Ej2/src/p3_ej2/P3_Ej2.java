/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3_ej2;

import java.util.Scanner;

/**
 *
 * @author santi
 */
public class P3_Ej2 {

    /**
     * @param args the command line arguments
     */
    static class Division {

        public static int divide(int a, int b) {
            try {
                return a / b;

            } catch (ArithmeticException e) {
                System.err.println("No se puede dividir por 0");
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 1;
        String linea;
        Scanner scan = new Scanner(System.in);
        try {

            System.out.print("\nIntroduzca dividendo: ");
            linea = scan.nextLine();
            num1 = Integer.parseInt(linea);

            System.out.print("\nIntroduzca divisor: ");
            linea = scan.nextLine();
            num2 = Integer.parseInt(linea);
        } catch (Exception e) {
            System.err.println("Numero introducido incorrecto");
        }

        System.out.println("\nEl resultado es: " + Division.divide(num1, num2));
    }
}
