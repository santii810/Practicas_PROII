/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3_ej3;

import java.time.LocalTime;

/**
 * Escribe un programa que cree la clase ProgramaRadio. En esta clase se
 * guardarán los atributos acerca de la hora de emisión, el número de minutos de
 * duración, el titulo y el nombre del locutor. Una vez creado, un programa de
 * radio no se cambia. La aplicación asume que la radio emite durante 24 horas,
 * desde las 0h. La duración mínima de un programa es de sesenta minutos (debe
 * lanzarse una excepción cuando se intente introducir una duración más
 * pequeña).
 *
 * Así, continuará pidiendo programas hasta que se cumplan o se superen las 24
 * horas (utilícese la clase LocalTime y su método plusMinutes(); para crear un
 * nuevo objeto LocalTime, LocalTime.of(h, m); la duración de todos los
 * programas no puede exceder los 1440 minutos).
 *
 * Nótese que el programa solamente debe pedir título, locutor y duración de
 * cada programa. Al final, el programa listará los programas de radio al
 * completo, con toda la información.
 *
 *
 * @author santi
 */
public class P3_Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProgramaRadio pr = new ProgramaRadio(LocalTime.of(12, 0), 90, "Titulo", "Locutor");
        pr.toString();
    }

}
