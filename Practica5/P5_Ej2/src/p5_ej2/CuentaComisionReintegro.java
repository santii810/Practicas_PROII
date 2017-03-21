/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5_ej2;

/**
 *
 * @author santi
 */
public class CuentaComisionReintegro extends Cuenta {

    public final static double COMISION_REINTEGRO = 1.05;

    public CuentaComisionReintegro(Tipo t, double saldo, double interes) {
        super(t, saldo, interes);
    }

    /**
     * Realiza una retirada de efectivo
     *
     * @param cantidadARetirar el valor de la retirada
     * @throws SaldoInsuficienteException si se sobrepasa el saldo
     */
    @Override
    public void reintegra(double cantidadARetirar) throws Exception {
        double cantidadTrasComision = cantidadARetirar * COMISION_REINTEGRO;
        if (cantidadTrasComision > getSaldo()) {
            throw new Exception("saldo sobrepasado con: " + cantidadTrasComision);
        }

        saldo -= cantidadTrasComision;
    }

}
