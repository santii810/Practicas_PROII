/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ej1;

/**
 *
 * @author santi
 */
class Coche {

    private String marca;
    private String modelo;
    private int numPuertas;
    private int capacidad;
    private int cv;
    private Tipo tipo;

    public static enum Tipo {
        MONOVOLUMEN, FAMILIAR, COMPACTO, BERLINA, CAMIONETA
    };

    public Coche(String marca, String modelo, int numPuertas, int capacidad, Tipo tipo, int cv) {
        this.marca = marca;
        this.modelo = modelo;
        this.numPuertas = numPuertas;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.cv = cv;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
 
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + tipo + ", cv " + cv + ") puertas: " + numPuertas + ", capacidad: " + capacidad;
    }

}
