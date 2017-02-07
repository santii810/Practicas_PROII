/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_ej5;

/**
 *
 *
 *
 * La información para manejar libros está formada por su título, autores,
 * editorial, año de edición e isbn. Para visualizar un libro se hace como en
 * este ejemplo: Titulo = Thinking in Java Autores = Bruce Eckel Editorial =
 * Prentice Hall Año = 2007 Isbn = 0131872486
 *
 * @author santi
 */
public class P1_Ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Libro libro = new Libro("Thinking in Java", "Bruce Eckel", "Prentice Hall", 2007, "0131872486");
        System.out.println(libro.toString());
    }

}
