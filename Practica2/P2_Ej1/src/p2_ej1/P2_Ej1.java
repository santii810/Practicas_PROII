/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ej1;

import java.util.Scanner;

/**
 *
 * Los coches se definen por su marca (marca), modelo (modelo), número de
 * puertas (numPuertas), capacidad del maletero en metros cúbicos (capacidad),
 * el tipo de coche (tipo, que puede ser monovolumen, familiar, compacto,
 * berlina y camioneta), y número de caballos (cv). Se expresan como "marca
 * modelo (tipo, cv CV)): puertas: numPuertas, capacidad: capacidad". El coche
 * de referencia es un Volkswagen Escarabajo de 4 puertas, de tipo compacto,
 * capacidad de maletero 100 metros cúbicos, 61CV.
 *
 * @author santi
 */
public class P2_Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Coche coche = new Coche("Volkswagen", "Escarabajo", 4, 100, Coche.Tipo.BERLINA, 61);
        System.out.println(coche.toString());

    }

}
