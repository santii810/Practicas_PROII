/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5_ej1;

/**
 *
 * @author santi
 */
/**
 * Representa cualquier producto financiero
 */
abstract class ProductoFinanciero {

    /**
     * El saldo del producto
     */
    protected double saldo;

    /* El beneficio o gasto del producto */
    private double interes;

    public ProductoFinanciero(double s, double i) {
        saldo = s;
        interes = i;
    }

    /**
     * @return Devuelve el saldo asociado al producto
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @return Devuelve el interés asociado al producto
     */
    public double getInteres() {
        return interes;
    }

    @Override
    public String toString() {
        return String.format("Saldo: %.2f (interés: %.2f)", getSaldo(), getInteres());
    }
}
