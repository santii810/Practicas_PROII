/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5_7;

import java.util.Calendar;

/**
 *
 * @author Soumase
 */
public class P5_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hora h = new Hora(5, 28);
        Fecha f = new Fecha(22, 3, 2017);
        Reunion r1 = new Reunion(h, f, "Coordinacion pro2");
        ReunionPeriodica r2 = new ReunionPeriodica(h, f, "Coordinacion pro2", ReunionPeriodica.Frecuencia.MENSUAL);

        Calendario cal = new Calendario("Reunion");
        System.out.println("\n-----Insertado 1-------------\n");
        cal.insertarReunion(r1);
        System.out.println(cal.toString() + "1");
        System.out.println("\n-----Insertado 2-------------\n");
        cal.insertarReunion(r1);
        System.out.println(cal.toString() + "2");
        System.out.println("\n-----Insertado 3-------------\n");
        cal.insertarReunion(r1);
        System.out.println(cal.toString());

        System.out.println(r2);
    }

}
