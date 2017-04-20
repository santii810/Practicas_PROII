/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5_7;

/**
 *
 * @author Soumase
 */
public class Hora {
    private int hora;
    private int minutos;

    public Hora(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    
    public String toString(){
        StringBuilder toret = new StringBuilder();
        
        toret.append(getHora());
        toret.append(":");
        toret.append(getMinutos());
        
        return toret.toString();
    }
}
