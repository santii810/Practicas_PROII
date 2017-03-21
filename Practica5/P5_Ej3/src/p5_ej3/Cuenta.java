/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5_ej3;

/**
 *
 * @author santi
 */
class Cuenta extends ProductoFinanciero {

    public enum Tipo {
        LIBRETA, AHORRO, VIVIENDA
    };

    /**
     * El tipo de la cuenta
     */
    private Tipo tipo;

    /**
     * Crea una nueva cuenta
     *
     * @param t el tipo de la cuenta
     * @param s el saldo de la cuenta
     * @param i el interés de la cuenta
     */
    public Cuenta(Tipo t, double s, double i) {
        super(s, i);

        tipo = t;
    }

    /**
     * @return Devuelve el tipo de cuenta
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Realiza un ingreso en la cuenta
     *
     * @param v el valor del ingreso
     */
    public void ingresa(double v) {
        saldo += v;
    }

    /**
     * Realiza una retirada de efectivo
     *
     * @param v el valor de la retirada
     * @throws SaldoInsuficienteException si se sobrepasa el saldo
     */
    public void reintegra(double v) throws Exception {
        if (v > getSaldo()) {
            throw new Exception("saldo sobrepasado con: " + v);
        }

        saldo -= v;
    }

    /**
     * Aplica el interés, aumentando el saldo
     */
    public void aplicaInteres() {
        saldo += (getSaldo() * getInteres());
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("Cuenta ");
        toret.append(getTipo().toString().toLowerCase());
        toret.append(": ");
        toret.append(super.toString());

        return toret.toString();
    }
}
