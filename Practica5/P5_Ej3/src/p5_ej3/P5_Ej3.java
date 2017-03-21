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
public class P5_Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empleado emp = new Empleado("José", 1200, new Cuenta(Cuenta.Tipo.LIBRETA, 2000, 2));
        emp.ingresaSalario();
        System.out.println(emp.toString());
        
        
    }
    
}
