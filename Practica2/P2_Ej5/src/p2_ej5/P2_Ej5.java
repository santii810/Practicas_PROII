/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ej5;

/**
 *
 * @author Santi
 */
public class P2_Ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Libro libro1 = new Libro("Thinking in Java", "Bruce Eckel", "Prentice Hall", 2007, "0131872486");
        Libro libro2 = new Libro("Thinking in Java2", "Bruce Eckel", "Prentice Hall", 2008, "0131872486");
        Libro libro3 = new Libro("Thinking in Java3", "Bruce Eckel", "Prentice Hall", 2009, "0131872486");
        Libro[] libros = new Libro[]{libro1, libro2, libro3};

        for (Libro libro : libros) {
            System.out.println(libro.toString() + "\n");
        }
    }

}
