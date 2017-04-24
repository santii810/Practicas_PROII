/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p7_ej6;

/**
 *
 * @author santi
 */
public class P7_EJ6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Diccionario<String, String> d = new Diccionario("Alto", "High");

        d.put("hola", "hello");
        d.put("adios", "good bye");
        d.put("Derecha", "right");
        d.put("Izquierda", "left");

        System.out.println(d.toString());

        System.out.println(d.isEmpty());

        d.clear("hola");
        System.out.println(d.toString());

    }

}
