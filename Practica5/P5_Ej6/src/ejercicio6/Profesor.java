/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

/**
 *
 * @author alumno
 */
public class Profesor extends Persona {
    private int despacho;
    private String asignatura;
    public Profesor(String i, int des, String asi){
        super(i);
        this.despacho=des;
        this.asignatura=asi;
    }

    public int getDespacho() {
        return despacho;
    }

    public String getAsignatura() {
        return asignatura;
    }
    public String toString(){
        StringBuilder toret = new StringBuilder();
        toret.append(super.toString());
        toret.append("\n");
        toret.append("el despacho es: " + getDespacho());
        toret.append("\n");
        toret.append("la asignatura es: " + getAsignatura());
        
        return toret.toString();
    }
    
}
