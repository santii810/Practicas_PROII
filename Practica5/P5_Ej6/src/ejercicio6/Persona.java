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
abstract class Persona {
    private String DNI;
    public Persona(String i){
        this.DNI = i;
    }

    public String getDNI() {
        return DNI;
    }
    
    public String toString(){
        StringBuilder toret=new StringBuilder();
        toret.append("El DNI es: " + getDNI());
        return toret.toString();
    }
}
