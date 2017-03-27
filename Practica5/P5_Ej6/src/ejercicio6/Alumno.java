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
public class Alumno extends Persona {
    private String planEstudios;
    public Alumno(String i,String plan){
        super(i);
        this.planEstudios=plan;
    }

    public String getPlanEstudios() {
        return planEstudios;
    }
    
    public String toString(){
        StringBuilder toret=new StringBuilder();
        toret.append(super.toString());
        toret.append("\n");
        toret.append("el plan es: " + getPlanEstudios());
        
        return toret.toString();
    }
    
    
}
