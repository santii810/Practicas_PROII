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
public class P5_Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 System.out.println("Sistema financiero");

        CuentaComisionReintegro c = new CuentaComisionReintegro(Cuenta.Tipo.AHORRO, 100, .05);
        System.out.println(c);

        c.ingresa(50);
        c.ingresa(120);
        c.aplicaInteres();
        System.out.println(c);

        Prestamo p = new Prestamo(12, 10000, .10);
        System.out.println(p);

        p.amortiza();
        p.amortiza();
        System.out.println(p);    }
    
}
