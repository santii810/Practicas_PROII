/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ej3;

/**
 *
 * @author Santi
 */
public class Curso {

    private Alumno[] alumnos;

    public Curso(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        String toret = "";
        for (Alumno alumno : alumnos) {
            toret += alumno + "\n";
        }
        return toret;
    }

}
