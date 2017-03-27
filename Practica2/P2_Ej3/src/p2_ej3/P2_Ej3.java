/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ej3;

/**
 *
 * Un alumno de PROII se define por un DNI (sin letra), unos apellidos y un
 * nombre. Además, tiene cuatro notas asociadas, una para el bloque1, otra para
 * el bloque2, la correspondiente al bloque3, y finalmente la de practicas.
 * Además de un constructor (que aceptará DNI, apellidos y nombre), y miembros
 * getter, será necesario también un miembro o miembros setter para poder
 * cambiar las cuatro notas. La nota final se calcula sabiendo que para cada
 * bloque, cada nota tiene un peso del 15%, mientras que la práctica supone el
 * porcentaje restante hasta el 100%. Cualquier nota se puede expresar de forma
 * textual, teniendo en cuenta que de 0 a 4 es un suspenso, de 5 a 6 un
 * aprobado, de 7 a 8 un notable, y de 9 a 10 sobresaliente. Los alumnos se
 * visualizan de la siguiente forma: "DNI - apellidos, nombre: bloque1, bloque2,
 * bloque3, practicas = final". Cualquier nota de un alumno se visualiza como
 * una cadena de texto con el formato de la nota textual del alumno, y entre
 * paréntesis la nota numérica, por ejemplo: aprobado(5.6). Para poder emitir un
 * boletín de notas, será necesaria una segunda clase Curso, que aceptará un
 * vector de varios alumnos y devolverá, en su método toString(), la información
 * de notas de todos los alumnos del curso, un alumno por línea
 *
 * @author Santi
 */
public class P2_Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno alu = new Alumno(0, "a", "b");
        alu.setNotas(new double[]{2,5,7,9});
        alu.setNotaFinal();
        
        System.out.println("\n\n Segunda parte:");
        Curso curso = new Curso(new Alumno[]{alu, alu, alu});
        System.out.println(   curso.toString());

    }

}
