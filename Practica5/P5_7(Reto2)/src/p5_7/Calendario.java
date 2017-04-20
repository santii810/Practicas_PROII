/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5_7;

/**
 *
 * @author santi
 */
public class Calendario {

    private static final int INITIAL_SIZE = 2;
    public Reunion[] reuniones;
    private String tema;
    private int numReuniones;

    public Calendario(String tema) {
        this.tema = tema;
        this.reuniones = new Reunion[INITIAL_SIZE];
    }

    public void insertarReunion(Reunion r) {
        System.out.println(numReuniones + " " + reuniones.length);
        if (numReuniones+1 == reuniones.length) {
            System.out.println("Aumentando");
            Reunion[] temp = reuniones;
            reuniones = new Reunion[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                reuniones[i] = temp[i];
            }
        }
        reuniones[numReuniones++] = r;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder("Nombre calendario: ");
        toret.append(tema);
        toret.append("\n");
        for (int i = 0; i < numReuniones; i++) {
            toret.append(reuniones[i]);
            toret.append("");
        }
        toret.append("\n");
        return toret.toString();
    }

}
