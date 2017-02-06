/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_ej3;

/**
 *
 * @author santi
 */
public class Persona {

    private static final String DNI_CHARS = "TRWAGMYFPDXBNJZSQVHLCKE";

    private String apellidos;
    private String nombre;
    private int dni;

    public Persona(String apellidos, String nombre, int dni) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" + "apellidos=" + apellidos + ", nombre=" + nombre + ", dni=" + dni + calcularLetra() + '}';
    }

    private char calcularLetra() {
        return this.DNI_CHARS.charAt(dni % 23);
    }

}
