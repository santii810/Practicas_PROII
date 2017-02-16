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
public class Alumno {

    private static final String[] notas = {"Suspenso", "Aprobado", "Notable", "Sobresaliente"};
    private int dni;
    private String apellidos;
    private String nombre;
    private double notaBloque1;
    private double notaBloque2;
    private double notaBloque3;
    private double notaPracticas;
    private double notaFinal;

    public Alumno(int dni, String apellidos, String nombre) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotaBloque1() {
        return notaBloque1;
    }

    public void setNotaBloque1(double notaBloque1) {
        this.notaBloque1 = notaBloque1;
    }

    public double getNotaBloque2() {
        return notaBloque2;
    }

    public void setNotaBloque2(double notaBloque2) {
        this.notaBloque2 = notaBloque2;
    }

    public double getNotaBloque3() {
        return notaBloque3;
    }

    public void setNotaBloque3(double notaBloque3) {
        this.notaBloque3 = notaBloque3;
    }

    public double getNotaPracticas() {
        return notaPracticas;
    }

    public void setNotaPracticas(double notaPracticas) {
        this.notaPracticas = notaPracticas;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

 

    public void setNotaFinal() {
        notaFinal += notaBloque1 * 0.15;
        notaFinal += notaBloque2 * 0.15;
        notaFinal += notaBloque3 * 0.15;
        notaFinal += notaPracticas * 0.55;
    }

    public String printNota(double nota) {
        String toret;
        if (nota >= 9) {
            toret = notas[3] + " (" + nota + ")";
        } else if (nota >= 7) {
            toret = notas[2] + " (" + nota + ")";
        } else if (nota >= 5) {
            toret = notas[1] + " (" + nota + ")";
        } else {
            toret = notas[0] + " (" + nota + ")";
        }
        return toret;
    }

    @Override
    public String toString() {
        return dni + " - "
                + apellidos + ", "
                + nombre + ": "
                + printNota(notaBloque1) + ", " + printNota(notaBloque2) + ", " + printNota(notaBloque3) + ", " + printNota(notaPracticas) + " = " + printNota(notaFinal);
    }

}
