/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3_ej1;

import java.util.Scanner;

/**
 *
 * @author santi
 */
public class P3_Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        boolean numeroCorrecto = false;
        double media = 0;

        do {
            try {
                System.out.println("Introduce la cantidad de numeros");
                n = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.err.println("No has introducido un numero");
            }
        } while (n <= 0);

        int[] numeros = new int[n];
        for (int i = 0; i < n; i++) {
            numeroCorrecto = false;
            do {
                System.out.println("Introduce un numero");
                try {
                    numeros[i] = Integer.parseInt(scanner.nextLine());
                    numeroCorrecto = true;
                } catch (NumberFormatException e) {
                    System.err.println("No has introducido un numero");
                }
            } while (!numeroCorrecto);
        }

        System.out.print("Numeros insertados: ");
        for (int numero : numeros) {
            System.out.print(" " + numero);
        }
        System.out.println("");

        for (int numero : numeros) {
            media += (double) numero / n;
        }
        System.out.println("Media: " + media);

    }

}
