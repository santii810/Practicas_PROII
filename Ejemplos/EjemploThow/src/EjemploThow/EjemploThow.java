/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploThow;

import java.util.Scanner;

/**
 *
 * @author Santi
 */
public class EjemploThow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num;

        boolean numeroCorrecto = true;
        do {

            try {
                numeroCorrecto = true;
                num = new Scanner(System.in).nextInt();
                if (num < 1) {
                    throw new Exception("santi");
                }
            } catch (Exception e) {
                numeroCorrecto = false;
                System.out.println("excepcion capturada");
            }
        } while (!numeroCorrecto);
    }

}
