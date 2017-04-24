/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p7_ej1;

/**
 *
 * @author santi
 */
/**
 * Representa triplas de valores
 */
public final class Tripla<T, S, U> {

    /**
     * El primer elemento
     */
    private T a;

    /**
     * El segundo elemento
     */
    private S b;

    /**
     * El tercer elemento
     */
    private U c;

    /**
     * Crea una nueva tripla
     *
     * @param a El primer elemento, de clase T
     * @param b El segundo elemento de clase S
     * @param c El tercer elemento, de clase U
     */
    public Tripla(T a, S b, U c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * @return El primer elemento, como objeto de clase T
     */
    public T getA() {
        return a;
    }

    /**
     * @return El segundo elemento, como objeto de clase S
     */
    public S getB() {
        return b;
    }

    /**
     * @return El tercer elemento, como objeto de clase U
     */
    public U getC() {
        return c;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)",
                getA().toString(),
                getB().toString(),
                getC().toString());
    }
}

