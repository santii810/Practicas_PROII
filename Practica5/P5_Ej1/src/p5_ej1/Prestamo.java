/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5_ej1;

class Prestamo extends ProductoFinanciero {

    /**
     * Num. de cuotas
     */
    private int numCuotas;

    /**
     * Importe de la cuota mensual
     */
    private double cuotaMensual;

    /**
     * Crea un nuevo preéstamo
     *
     * @param nc num. de cuotas
     * @param s el saldo
     * @param i el interés
     */
    public Prestamo(int nc, double s, double i) {
        super(s, i);

        numCuotas = nc;
        cuotaMensual = (getSaldo() + (getSaldo() * getInteres())) / nc;
    }

    /**
     * @return el num. de cuotas pendientes
     */
    public int getNumCuotas() {
        return numCuotas;
    }

    /**
     * @return el importe de la cuota mensual
     */
    public double getCuotaMensual() {
        return cuotaMensual;
    }

    /**
     * Realiza el ingreso adecuado
     */
    public void amortiza() {
        if (getSaldo() >= 0
                && getNumCuotas() > 0) {
            saldo -= getCuotaMensual();
            --numCuotas;
        }
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("Préstamo (");
        toret.append(getNumCuotas());
        toret.append(" cuotas pendientes de ");
        toret.append(String.format("%.2f", getCuotaMensual()));
        toret.append(" EUR): ");
        toret.append(super.toString());

        return toret.toString();
    }
}
