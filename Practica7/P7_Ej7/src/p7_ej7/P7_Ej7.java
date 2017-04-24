/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p7_ej7;

/**
 *
 * @author santi
 */
public class P7_Ej7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaTemperaturas lt = new ListaTemperaturas();

        lt.inserta("Orense", 25.0);
        lt.inserta("Vigo", 20.0);

        System.out.println(lt);
    }
}


