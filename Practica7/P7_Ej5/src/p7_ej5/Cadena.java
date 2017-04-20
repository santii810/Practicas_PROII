/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p7_ej5;

import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class Cadena {

    ArrayList<Character> cadena;

    public Cadena() {
        this.cadena = new ArrayList<>();
    }

    public char get(int i) {
        return this.cadena.get(i);
    }

    public void set(int i, char c) {
        this.cadena.set(i, c);
    }

    public void inserta(int i, char c) {
        this.cadena.add(i, c);
    }

    public void inserta(char c) {
        this.cadena.add(c);
    }

    public void borra(int i) {
        this.cadena.remove(i);
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        for (Character character : cadena) {
            toret.append(character);
            toret.append(" ");
        }
        return toret.toString();
    }
}
