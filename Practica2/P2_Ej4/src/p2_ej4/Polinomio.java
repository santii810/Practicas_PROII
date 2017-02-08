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
public class Polinomio {

    private Elemento[] elementos;

    public Polinomio(Elemento[] elementos) {
        this.elementos = elementos;
    }

    public Elemento[] getElementos() {
        return elementos;
    }

    public void setElementos(Elemento[] elementos) {
        this.elementos = elementos;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder("Polinomio: ");

        for (int i = 0; i < elementos.length; i++) {
            toret.append(elementos[i].getCoeficiente() + "x");
            if (elementos[i].getGrado() > 0) {
                toret.append("^" + elementos[i].getGrado());
            }
            if (i != elementos.length - 1) {
                toret.append(" + ");
            }
        }

        return toret.toString();
    }

}
