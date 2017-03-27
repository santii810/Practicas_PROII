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

    private final static int numNotas = 4;
    private final static double[] valoracion = new double[]{0.15, 0.15, 0.15, 0.55};
    private int dni;
    private String apellidos;
    private String nombre;
    private double notaFinal;
    private double[] notas;

    public enum Nota {
        SUSPENSO, APROBADO, NOTABLE, SOBRESALIENTE
    };

    public Alumno(int dni, String apellidos, String nombre) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.notas = new double[numNotas];
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

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public void setNotaFinal() {
        for (int i = 0; i < numNotas; i++) {
            notaFinal += notas[i] * valoracion[i];
        }
    }

    public String printNota(double nota) {
        String toret;
        if (nota >= 9) {
            toret = Nota.SOBRESALIENTE + " (" + nota + ")";
        } else if (nota >= 7) {
            toret = Nota.NOTABLE + " (" + nota + ")";
        } else if (nota >= 5) {
            toret = Nota.APROBADO + " (" + nota + ")";
        } else {
            toret = Nota.SUSPENSO + " (" + nota + ")";
        }
        return toret;
    }

    @Override
    public String toString() {
        
        StringBuilder toret = new StringBuilder();
        toret.append(dni);
        toret.append(" - ");
        toret.append(apellidos);
        toret.append(", ");
        toret.append(nombre);
        toret.append(": ");
        for (int i = 0; i < numNotas; i++) {
            toret.append(printNota(notas[i]));
            toret.append(", ");
        }
        return toret.toString();
    }
}
