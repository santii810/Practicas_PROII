/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ej4;

/**
 *
 * @author Santi
 */
public class Elemento {

    private int coeficiente;
    private int grado;

    public Elemento(int coeficiente, int grado) {
        this.coeficiente = coeficiente;
        this.grado = grado;
    }

    public int getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(int coeficiente) {
        this.coeficiente = coeficiente;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return "Elemento{" + "coeficiente=" + coeficiente + ", grado=" + grado + '}';
    }

}
