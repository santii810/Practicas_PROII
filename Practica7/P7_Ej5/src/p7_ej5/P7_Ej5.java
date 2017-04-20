/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p7_ej5;

/**
 *
 * @author santi
 */
public class P7_Ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cadena c = new Cadena();
        c.inserta('a');
        c.inserta('b');
        c.inserta('c');
        System.out.println(c.toString());
        c.borra(0);
        System.out.println(c.toString());
        c.get(0);
        System.out.println(c.toString());
        c.inserta(0, 'e');
        System.out.println(c.toString());
        c.set(2, 'u');
        System.out.println(c.toString());
    }

}
