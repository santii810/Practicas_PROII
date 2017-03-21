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
public class Empleado {
    private String nombre;
    private double salario;
    private Cuenta cuenta;

    public Empleado(String nombre, double salario, Cuenta cuenta) {
        this.nombre = nombre;
        this.salario = salario;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    public void ingresaSalario(){
        this.cuenta.ingresa(this.salario);
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", salario=" + salario + ", cuenta=" + cuenta + '}';
    }
    
    
}
